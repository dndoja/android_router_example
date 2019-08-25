package com.dndoja.routingexample.screens.details

import com.dndoja.routingexample.core.OnRoutingRequestedListener
import com.dndoja.routingexample.core.Presenter
import com.dndoja.routingexample.models.ItemDetails

class DetailsPresenter: Presenter<ItemDetails, DetailsViewContract> {
    override var state: ItemDetails = ItemDetails()
    set(value) {
        field = value
        contract?.detailsList = value.details
    }

    override var contract: DetailsViewContract? = null

    override var onRoutingRequestedListener: OnRoutingRequestedListener? = null
}