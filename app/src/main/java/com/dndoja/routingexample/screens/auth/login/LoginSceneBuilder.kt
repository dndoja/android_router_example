package com.dndoja.routingexample.screens.auth.login

import android.content.Context
import com.dndoja.routingexample.core.ScreenBuilder

class LoginSceneBuilder(override val context: Context) : ScreenBuilder<LoginScene>{
    override fun build(): LoginScene {
        val presenter = LoginPresenterImp()
        val view = LoginScene(context)
        view.presenter = presenter
        presenter.contract = view
        return view
    }
}