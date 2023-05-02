package com.yeminnaing.customviewassignment.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yeminnaing.customviewassignment.R
import com.yeminnaing.customviewassignment.deligates.MainItemDelegate
import com.yeminnaing.customviewassignment.viewholders.ProfileImageViewHolder
import kotlinx.android.synthetic.main.view_holder_profile_image.view.*

class ProfileImageAdapter(private val delegate: MainItemDelegate) : RecyclerView.Adapter<ProfileImageViewHolder>() {

    private val profileImageList = listOf(
        R.drawable.honeynweoo,
        R.drawable.honeynweoo,
        R.drawable.honeynweoo,
        R.drawable.plus
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileImageViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_holder_profile_image, parent, false)
        return ProfileImageViewHolder(view,delegate)
    }

    override fun onBindViewHolder(holder: ProfileImageViewHolder, position: Int) {
        val profileImage = profileImageList[position]
        holder.itemView.ivProfileImage.setImageResource(profileImage)

        holder.itemView.setOnClickListener {
            if(holder.adapterPosition == profileImageList.lastIndex) {
                delegate.onTapTask()
            } else {
                delegate.onTapProfileImage()
            }
        }
    }

    override fun getItemCount(): Int {
        return profileImageList.size
    }
}