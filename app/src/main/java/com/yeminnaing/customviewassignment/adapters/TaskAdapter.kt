package com.flexath.msixteenassignment.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yeminnaing.customviewassignment.viewholders.TaskViewHolder
import com.yeminnaing.customviewassignment.R
import com.yeminnaing.customviewassignment.deligates.MainItemDelegate

class TaskAdapter(private val delegate: MainItemDelegate) : RecyclerView.Adapter<TaskViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.viewpod_text_items, parent, false)
        return TaskViewHolder(view,delegate)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 10
    }
}