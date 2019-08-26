package com.dndoja.routingexample.screens.home.details

import com.dndoja.routingexample.core.Presenter
import com.dndoja.routingexample.models.ItemDetails
import java.io.Serializable

class DetailsPresenter: Presenter<ItemDetails, DetailsViewContract, Serializable> {
    override var state: ItemDetails = ItemDetails()
    set(value) {
        field = value
        contract?.detailsList = value.details
    }

    override var contract: DetailsViewContract? = null

    override var onFinishedListener: ((Serializable) -> Unit)? = null
}