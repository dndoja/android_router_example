package com.dndoja.routingexample.screens.master

import com.dndoja.routingexample.core.OnRoutingRequestedListener
import com.dndoja.routingexample.core.Presenter
import com.dndoja.routingexample.models.Item
import com.dndoja.routingexample.screens.SceneType

interface MasterPresenter: Presenter<Item,MasterSceneContract> {
    fun onShowDetailsButtonClicked()
}

class MasterPresenterImp: MasterPresenter{
    override var onRoutingRequestedListener: OnRoutingRequestedListener? = null
    override var state: Item = Item("hello")
        set(value) {
            field = value
            contract?.name = value.name
        }

    override var contract: MasterSceneContract? = null

    override fun onShowDetailsButtonClicked(){
        onRoutingRequestedListener?.onRoutingRequested(SceneType.DETAILS,null)
    }
}