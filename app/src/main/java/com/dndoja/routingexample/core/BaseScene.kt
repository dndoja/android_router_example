package com.dndoja.routingexample.core

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout

open class BaseScene<T: Presenter<*,*,*>> @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyle: Int = 0
) : FrameLayout(context, attrs, defStyle){

    var presenter: T? = null

    fun setViewById(id: Int){
        removeAllViews()
        val view = View.inflate(context,id,null)
        view.layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)
        addView(view)
    }
}