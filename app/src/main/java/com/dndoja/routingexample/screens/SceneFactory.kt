package com.dndoja.routingexample.screens

import android.content.Context
import com.dndoja.routingexample.core.BaseScene
import com.dndoja.routingexample.models.Item
import com.dndoja.routingexample.models.ItemDetails
import com.dndoja.routingexample.screens.home.details.DetailsSceneBuilder
import com.dndoja.routingexample.screens.home.master.MasterSceneBuilder
import java.io.Serializable

enum class SceneType {
    MASTER,DETAILS
}

class SceneFactory(private val context: Context, private val stateTree: HashMap<SceneType,Serializable> = HashMap()){
    fun buildScene(screen: SceneType): BaseScene<*>{
        return when (screen){
            SceneType.DETAILS -> DetailsSceneBuilder(context).build().apply{
                val restoredState = stateTree[SceneType.DETAILS] as? ItemDetails
                if (restoredState != null) presenter?.state = restoredState
            }

            SceneType.MASTER -> MasterSceneBuilder(context).build().apply{
                val restoredState = stateTree[SceneType.MASTER] as? Item
                if (restoredState != null) presenter?.state = restoredState
            }
        }
    }
}