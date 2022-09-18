package cbl.tools.loginmvp.util

import android.util.Patterns

object StringUtil {
    fun isEmailValidate(email: String): Boolean {
        return email.isNotBlank() && Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    fun isPwdValidate(pwd:String):Boolean{
        return pwd.isNotBlank()
    }
}