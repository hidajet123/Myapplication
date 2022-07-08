package com.example.myapplication.listusers

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.UserCallback
import com.example.myapplication.network.Users
import inflateView

class ListUsersAdapter(val lista: List<Users>, val callback: UserCallback) :
    RecyclerView.Adapter<UsersViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersViewHolder {
        val view = parent.inflateView(R.layout.user_item)
        return UsersViewHolder(view)
    }

    override fun onBindViewHolder(holder: UsersViewHolder, position: Int) {
        holder.bind(lista.get(position), callback)
    }

    override fun getItemCount(): Int = lista.size


}