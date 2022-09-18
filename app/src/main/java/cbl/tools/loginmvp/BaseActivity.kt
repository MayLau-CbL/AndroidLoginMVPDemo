package cbl.tools.loginmvp

import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {
    protected fun showLoadingDialog() {
        //TODO: loading
    }

    protected fun dismissLoadingDialog() {
        //TODO: loading
    }

    protected fun showGeneralDialog(msg:String){
        //TODO: general dialog
    }
}