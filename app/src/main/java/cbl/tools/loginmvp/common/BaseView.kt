package cbl.tools.loginmvp.common

interface IBaseView {
    fun showProgressDialog()
    fun dismissProgressDialog()

    fun showDialog(msg: String)

    fun getStringById(resId:Int):String
}