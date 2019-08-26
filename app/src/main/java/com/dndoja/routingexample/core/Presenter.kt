package com.dndoja.routingexample.core

import java.io.Serializable

interface Presenter<MODEL: Serializable, CONTRACT, OUTPUT: Serializable>{
    var state: MODEL
    var contract: CONTRACT?
    var onFinishedListener: ((output: OUTPUT) -> Unit)?

    fun onDestroy(){
        contract = null
    }
}