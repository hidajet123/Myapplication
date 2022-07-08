package com.example.myapplication.network

data class Result(
    val page: Int,
    val per_page: Int,
    val total: Int,
    val total_pages: Int,
    val data: List<Users>,
    val support: Support
)

data class Data(val rows: ArrayList<Users>)
data class Support(
    val url: String,
    val text: String,

    )

data class Users(
    val id: Int,
    val email: String,
    val first_name: String,
    val last_name: String,
    val avatar: String
)
