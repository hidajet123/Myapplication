package com.example.myapplication.database

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface UserDao {

    @Insert
    fun insert(user: UserDataBase)

}