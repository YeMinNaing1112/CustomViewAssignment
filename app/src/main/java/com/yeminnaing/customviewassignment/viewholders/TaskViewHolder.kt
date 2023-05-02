package com.yeminnaing.customviewassignment.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.yeminnaing.customviewassignment.deligates.MainItemDelegate
import kotlinx.android.synthetic.main.viewpod_text_items.view.*

class TaskViewHolder(itemView: View,private val delegate: MainItemDelegate) : RecyclerView.ViewHolder(itemView) {

    init {
        setUpListeners()
    }

    private fun setUpListeners() {
        itemView.ivProfileImageTask.setOnClickListener {
            delegate.onTapProfileImage()
        }

        itemView.setOnClickListener {
            delegate.onTapTask()
        }
    }
}