package com.example.myapplication.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class UserDataBase(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    @ColumnInfo(name = "name")
    val first_name: String,
    @ColumnInfo(name = "surname")
    val last_name: String,
    @ColumnInfo(name = "email")
    val email: String,
    @ColumnInfo(name = "avatar")
    val avatar: String
)