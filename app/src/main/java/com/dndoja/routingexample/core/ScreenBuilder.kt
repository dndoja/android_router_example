package com.dndoja.routingexample.core

import android.content.Context

interface ScreenBuilder<out T:BaseScene<*>>{
    val context: Context
    fun build(): T
}
