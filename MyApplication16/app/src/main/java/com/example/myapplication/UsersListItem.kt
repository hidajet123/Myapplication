package com.example.myapplication

import android.util.Log
import com.example.myapplication.listusers.ListUsersAdapter
import com.example.myapplication.network.Users

class UsersListItem(list: List<Users>, callback: UserCallback) {
    var adapter: ListUsersAdapter?=null

    init {
        Log.d("Lista 1: ", list.toString())
        adapter = ListUsersAdapter(list, callback);
        Log.d("Adapter: ", adapter.toString())

    }

}