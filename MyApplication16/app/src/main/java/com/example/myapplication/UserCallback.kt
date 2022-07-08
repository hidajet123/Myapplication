package com.example.myapplication

import com.example.myapplication.network.Users

interface UserCallback {
    fun onUserClick(users: Users)
}