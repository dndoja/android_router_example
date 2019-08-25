package com.dndoja.routingexample.models

import java.io.Serializable

data class Item (
        val name: String,
        val details: ItemDetails = ItemDetails()
): Serializable