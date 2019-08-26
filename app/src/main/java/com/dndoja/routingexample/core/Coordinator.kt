package com.dndoja.routingexample.core

interface Coordinator {
    val router: Router
   // val stateMachine: StateMachine<*,*,*>
    val childCoordinators: Array<Coordinator>
    fun start()
}