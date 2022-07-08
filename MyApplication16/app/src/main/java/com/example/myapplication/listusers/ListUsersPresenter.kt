package com.example.myapplication.listusers

import com.example.myapplication.network.AplicationApiService
import com.example.myapplication.network.Result
import com.example.myapplication.network.Users
import retrofit2.Call
import retrofit2.Response

class ListUsersPresenter(view: View) {

    private var mainView: View = view

    fun users() {
        val api = AplicationApiService.create()
        api.getUsers().enqueue(object : retrofit2.Callback<Result> {
            override fun onResponse(call: Call<Result>, response: Response<Result>) {
                mainView.showUsers(response.body()?.data!!)
            }

            override fun onFailure(call: Call<Result>, t: Throwable) {
                mainView.showError(t.message.toString())
            }

        })
    }

    interface View {
        fun showError(error: String);
        fun showUsers(list: List<Users>)
    }
}