package cbl.tools.loginmvp.auth.signin

import android.os.Bundle
import cbl.tools.loginmvp.R
import cbl.tools.loginmvp.common.BaseActivity

class SignInActivity : BaseActivity(), ISignInView {
    private lateinit var presenter: ISignInPresenter<ISignInView, ISignInInteractor>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initPresenter()
        setContentView(R.layout.activity_sign_in)
    }

    private fun initPresenter() {
        presenter = SignInPresenter(interactor = SignInInteractor())
        presenter.onAttach(this)
    }

    override fun onDestroy() {
        presenter.onDetach()
        super.onDestroy()
    }

    /**
     * View
     */

    override fun getStringById(resId:Int):String{
        return this.getString(resId)
    }

    override fun showProgressDialog() {
        super.showLoadingDialog()
    }

    override fun dismissProgressDialog() {
        super.dismissLoadingDialog()
    }

    override fun showDialog(msg: String) {
        super.showGeneralDialog(msg = msg)
    }

    override fun showEmailErrorMsg(msg: String) {
        TODO("Not yet implemented")
    }

    override fun showPwdErrorMsg(pwd: String) {
        TODO("Not yet implemented")
    }

    override fun signInSuccess(token: String) {
        TODO("Not yet implemented")
    }
}