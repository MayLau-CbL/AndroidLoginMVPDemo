package cbl.tools.loginmvp.auth.signin

import cbl.tools.loginmvp.IBaseView

interface ISignInView : IBaseView {
    fun showEmailErrorMsg(msg: String)
    fun showPwdErrorMsg(pwd: String)
    fun signInSuccess(token: String)
}
