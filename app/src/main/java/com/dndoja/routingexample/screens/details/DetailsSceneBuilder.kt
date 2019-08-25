package com.dndoja.routingexample.screens.details

import android.content.Context
import com.dndoja.routingexample.core.ScreenBuilder

class DetailsSceneBuilder(override val context: Context) : ScreenBuilder<DetailsScene>{
    override fun build(): DetailsScene {
        val presenter = DetailsPresenter()
        val view = DetailsScene(context)
        view.presenter = presenter
        presenter.contract = view
        return view
    }
}