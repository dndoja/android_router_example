package com.dndoja.routingexample.screens.auth

import android.content.Context
import com.dndoja.routingexample.core.Coordinator
import com.dndoja.routingexample.core.Router
import com.dndoja.routingexample.screens.auth.login.LoginSceneBuilder

class AuthCoordinator(val context: Context, override val router: Router): Coordinator{
    enum class Status{
        AT_LOGIN,FINISHED
    }

    var token: String? = null

    private var state: Status = Status.AT_LOGIN
    private set(value) {
        field = value
        start()
    }

    override val childCoordinators: Array<Coordinator> = arrayOf()

    override fun start() {
        when(state){
            Status.AT_LOGIN -> toLogin()
            Status.FINISHED -> if (token != null){
                toHome()
            }else{
                toLogin()
            }
        }
    }

    private fun toLogin(){
        val loginScene = LoginSceneBuilder(context).build()
        loginScene.presenter!!.onFinishedListener = {
            token ->
            run {
                this.token = token
                this.state = Status.FINISHED
            }
        }
        router.pushScreen(loginScene)
    }

    private fun toHome(){

    }
}