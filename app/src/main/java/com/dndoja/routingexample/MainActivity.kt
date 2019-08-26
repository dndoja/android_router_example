package com.dndoja.routingexample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import com.dndoja.routingexample.core.BaseRouter
import com.dndoja.routingexample.core.Coordinator
import com.dndoja.routingexample.screens.SceneFactory
import com.dndoja.routingexample.screens.SceneType
import com.dndoja.routingexample.screens.auth.AuthCoordinator

class MainActivity : AppCompatActivity() {

    lateinit var router: BaseRouter
    lateinit var sceneFactory: SceneFactory
    lateinit var rootCoordinator: Coordinator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rootView = findViewById<ViewGroup>(R.id.root_view)
        sceneFactory = SceneFactory(this)

        router = BaseRouter(rootView)
        rootCoordinator = AuthCoordinator(this,router)
    }

    override fun onBackPressed() {
        if (router.canNavigateBack()){
            router.popScreen()
        }else{
            super.onBackPressed()
        }
    }
}
