package com.example.myapplication.listusers

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.UserCallback
import com.example.myapplication.network.Users
import loadFromUrl

class UsersViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val img: ImageView = itemView.findViewById(R.id.imageView2)
    val name: TextView = itemView.findViewById(R.id.name)
    fun bind(list: Users, callback: UserCallback) {
        img.loadFromUrl(list.avatar)
        name.text = list.first_name
        itemView.setOnClickListener {
            callback.onUserClick(list)
        }
    }
}