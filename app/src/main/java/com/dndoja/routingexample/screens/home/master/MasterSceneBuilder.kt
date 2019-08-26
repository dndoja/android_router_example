package com.dndoja.routingexample.screens.home.master

import android.content.Context
import com.dndoja.routingexample.core.ScreenBuilder
import com.dndoja.routingexample.screens.auth.login.LoginPresenterImp
import com.dndoja.routingexample.screens.auth.login.LoginScene

class MasterSceneBuilder(override val context: Context) : ScreenBuilder<MasterScene>{
    override fun build(): MasterScene {
        val presenter = MasterPresenterImp()
        val view = MasterScene(context)
        view.presenter = presenter
        presenter.contract = view
        return view
    }
}