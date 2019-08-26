package com.dndoja.routingexample.core

import android.view.ViewGroup
import java.util.*

interface Router {
    val screensStack: Stack<BaseScene<*>>
    val rootView: ViewGroup

    fun canNavigateBack(): Boolean{
        return screensStack.size > 1
    }

    fun pushScreen(scene: BaseScene<*>){
        screensStack.push(scene)
        rootView.removeAllViews()
        rootView.addView(scene)
    }

    fun popScreen(){
        screensStack.pop()
        rootView.removeAllViews()
        rootView.addView(screensStack.peek())
    }
}

class BaseRouter(override val rootView: ViewGroup,
                 override val screensStack: Stack<BaseScene<*>> = Stack()
) : Router
