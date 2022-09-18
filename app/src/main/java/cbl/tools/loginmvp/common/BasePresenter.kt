package cbl.tools.loginmvp.common

interface IBasePresenter<V : IBaseView, I : IBaseInteractor> {
    fun onAttach(view: V)
    fun onDetach()
}

abstract class BasePresenter<V : IBaseView, I : IBaseInteractor>(val interactor: I) :
    IBasePresenter<V, I> {
    var view: V? = null

    override fun onAttach(view: V) {
        this.view = view
    }

    override fun onDetach() {
        this.view = null
    }
}

