package cbl.tools.loginmvp.auth.signin

import cbl.tools.loginmvp.R
import cbl.tools.loginmvp.BasePresenter
import cbl.tools.loginmvp.IBasePresenter
import cbl.tools.loginmvp.util.StringUtil

interface ISignInPresenter<V : ISignInView, I : ISignInInteractor> : IBasePresenter<V, I> {
    fun signIn(email: String, pwd: String)
    fun forgetPassword(email: String)
}

class SignInPresenter<V : ISignInView, I : ISignInInteractor>(interactor: I) :
    BasePresenter<V, I>(interactor = interactor), ISignInPresenter<V, I> {

    override fun signIn(email: String, pwd: String) {
        if (StringUtil.isEmailValidate(email = email)) {
            view?.getStringById(R.string.sign_in_incorrect_email)
                ?.apply { view?.showEmailErrorMsg(msg = this) }
            return
        }
        if (StringUtil.isPwdValidate(pwd = pwd)) {
            view?.getStringById(R.string.sign_in_incorrect_pwd)
                ?.apply { view?.showPwdErrorMsg(pwd = this) }
            return
        }
        view?.showProgressDialog()
        val result = interactor.signInByEmail(email = email, pwd = pwd)
        if (result.isSuccess) {
            result.getOrNull()?.apply {
                view?.signInSuccess(this)
            } ?: let {
                view?.getStringById(R.string.sign_in_failure)?.apply {
                    view?.showDialog(msg = this)
                }
            }
        } else {
            view?.getStringById(R.string.common_network_fail)?.apply {
                view?.showDialog(msg = this)
            }
        }
        view?.dismissProgressDialog()
    }

    override fun forgetPassword(email: String) {
        if (StringUtil.isEmailValidate(email = email)) {
            view?.getStringById(R.string.sign_in_incorrect_email)
                ?.apply { view?.showEmailErrorMsg(msg = this) }
            return
        }
        view?.showProgressDialog()
        val result = interactor.forgetPwd(email = email)
        if (result.isSuccess) {
            if (result.getOrDefault(defaultValue = false)) {
                view?.getStringById(R.string.sign_in_forget_password_success)?.apply {
                    view?.showDialog(msg = this)
                }
            } else {
                view?.getStringById(R.string.sign_in_forget_password_failure)?.apply {
                    view?.showDialog(msg = this)
                }
            }
        } else {
            view?.getStringById(R.string.common_network_fail)?.apply {
                view?.showDialog(msg = this)
            }
        }
        view?.dismissProgressDialog()
    }

}

