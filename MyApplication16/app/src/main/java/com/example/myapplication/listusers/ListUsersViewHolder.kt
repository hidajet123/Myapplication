package com.example.myapplication.listusers

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.UsersListItem

class ListUsersViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val recyclerView: RecyclerView = itemView.findViewById(R.id.listUsers)

    fun bind(usersListItem: UsersListItem) {
        recyclerView.adapter = usersListItem.adapter
    }
}