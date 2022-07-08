package com.example.myapplication.listusers


import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.UsersListItem
import inflateView

class ListUsersActivityAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val list: ArrayList<UsersListItem> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = parent.inflateView(R.layout.list_users)
        return ListUsersViewHolder(view);
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ListUsersViewHolder -> {
                holder.bind(list.get(position))
            }

        }
    }

    override fun getItemCount(): Int = list.size

    fun addItem(item: UsersListItem) {
        list.add(item)
        notifyItemInserted(list.size + 1)
    }
}