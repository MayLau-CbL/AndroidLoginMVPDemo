package cbl.tools.loginmvp.auth.signin

import cbl.tools.loginmvp.common.BaseInteractor
import cbl.tools.loginmvp.common.IBaseInteractor

interface ISignInInteractor : IBaseInteractor {
    fun signInByEmail(email:String, pwd:String):Result<String?>
    fun forgetPwd(email:String):Result<Boolean>
}

class SignInInteractor() : BaseInteractor(), ISignInInteractor {
    override fun signInByEmail(email: String, pwd: String): Result<String?> {
        return Result.success("some token")
    }

    override fun forgetPwd(email: String): Result<Boolean> {
        return Result.success(true)
    }
}