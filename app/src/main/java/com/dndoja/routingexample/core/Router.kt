package com.dndoja.routingexample.core

import android.view.ViewGroup
import com.dndoja.routingexample.screens.SceneFactory
import com.dndoja.routingexample.screens.SceneType
import java.io.Serializable
import java.util.*
import kotlin.collections.ArrayList

interface OnRoutingRequestedListener {
    fun onRoutingRequested(destination: SceneType, payload: Serializable?)
}

interface Router: OnRoutingRequestedListener {
    val sceneFactory: SceneFactory
    val screensStack: Stack<Route>
    val rootView: ViewGroup

    fun canNavigateBack(): Boolean{
        return screensStack.size > 1
    }

    fun pushScreen(sceneType: SceneType){
        val scene = sceneFactory.buildScene(sceneType)
        scene.presenter?.onRoutingRequestedListener = this
        screensStack.push(Route(sceneType,scene))
        rootView.removeAllViews()
        rootView.addView(scene)
    }

    fun popScreen(){
        screensStack.pop()
        rootView.removeAllViews()
        rootView.addView(screensStack.peek().scene)
    }

    fun getNavigationState(): Array<SceneType>{
        return screensStack.map { route -> route.type }.toTypedArray()
    }

    fun setNavigationState(state: ArrayList<SceneType>){
        screensStack.clear()
        state.forEach { sceneType ->
            val scene = sceneFactory.buildScene(sceneType)
            scene.presenter?.onRoutingRequestedListener = this
            screensStack.push(Route(sceneType,scene))
        }
        rootView.removeAllViews()
        rootView.addView(screensStack.peek().scene)
    }

    override fun onRoutingRequested(destination: SceneType, payload: Serializable?) {
        pushScreen(destination)
    }
}

class BaseRouter(override val rootView: ViewGroup,
                 override val sceneFactory: SceneFactory,
                 override val screensStack: Stack<Route> = Stack()
) : Router
