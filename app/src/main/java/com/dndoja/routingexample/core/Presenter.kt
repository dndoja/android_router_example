package com.dndoja.routingexample.core

import java.io.Serializable

interface Presenter<T: Serializable, G>{
    var state: T
    var contract: G?
    var onRoutingRequestedListener: OnRoutingRequestedListener?

    fun onDestroy(){
        contract = null
    }
}