package com.dndoja.routingexample.screens.master

import android.content.Context
import android.util.AttributeSet
import android.widget.Button
import android.widget.TextView
import com.dndoja.routingexample.R
import com.dndoja.routingexample.core.BaseScene

interface MasterSceneContract{
    var name: String
}

class MasterScene @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : BaseScene<MasterPresenter>(context, attrs, defStyleAttr), MasterSceneContract{

    override var name: String = ""
        set(value) {
            field = value
            itemNameLabel.text = name
        }

    private val showDetailsButton: Button
    private val itemNameLabel: TextView

    init {
        setViewById(R.layout.screen_master)
        showDetailsButton = findViewById(R.id.show_details_button)
        itemNameLabel = findViewById(R.id.item_name_label)
        showDetailsButton.setOnClickListener { presenter?.onShowDetailsButtonClicked() }
    }
}