package com.dndoja.routingexample.screens.auth.login

import com.dndoja.routingexample.core.Presenter
import com.dndoja.routingexample.models.Item
import com.dndoja.routingexample.screens.home.master.LoginSceneContract

interface LoginPresenter: Presenter<Item, LoginSceneContract,String> {
    fun onLoginButtonClicked()
}

class LoginPresenterImp: LoginPresenter {
    override var state: Item = Item("hello")
        set(value) {
            field = value
            contract?.name = value.name
        }

    override var onFinishedListener: ((String) -> Unit)? = null
    override var contract: LoginSceneContract? = null

    override fun onLoginButtonClicked(){
        onFinishedListener?.invoke("hello i am a token")
    }
}