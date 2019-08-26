package com.dndoja.routingexample.screens.home.master

import com.dndoja.routingexample.core.Presenter
import com.dndoja.routingexample.models.Item
import com.dndoja.routingexample.models.ItemDetails

interface MasterPresenter: Presenter<Item,LoginSceneContract,ItemDetails> {
    fun onShowDetailsButtonClicked()
}

class MasterPresenterImp: MasterPresenter {
    override var state: Item = Item("hello")
        set(value) {
            field = value
            contract?.name = value.name
        }

    override var onFinishedListener: ((ItemDetails) -> Unit)? = null
    override var contract: LoginSceneContract? = null

    override fun onShowDetailsButtonClicked() {
        onFinishedListener?.invoke(state.details)
    }
}