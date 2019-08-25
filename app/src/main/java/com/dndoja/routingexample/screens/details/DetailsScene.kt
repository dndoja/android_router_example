package com.dndoja.routingexample.screens.details

import android.content.Context
import android.util.AttributeSet
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import com.dndoja.routingexample.R
import com.dndoja.routingexample.core.BaseScene

interface DetailsViewContract{
    var detailsList: List<String>
    var title: String
}

class DetailsScene @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : BaseScene<DetailsPresenter>(context, attrs, defStyleAttr), DetailsViewContract {

    override var detailsList: List<String> = ArrayList()
        set(value) {
            field = value
            detailsListAdapter.clear()
            detailsListAdapter.addAll(value)
        }

    override var title: String = ""
        set(value) {
            field = value
            titleView.text = value
        }

    private val titleView: TextView
    private val detailsListView: ListView
    private val detailsListAdapter: ArrayAdapter<String>

    init {
        setViewById(R.layout.screen_details)
        titleView = findViewById(R.id.details_title)
        detailsListView = findViewById(R.id.details_list)
        detailsListAdapter = ArrayAdapter(context, android.R.layout.simple_list_item_1, ArrayList<String>())
    }
}

