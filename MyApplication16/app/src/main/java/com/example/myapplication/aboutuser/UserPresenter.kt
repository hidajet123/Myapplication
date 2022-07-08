package com.example.myapplication.aboutuser

import com.example.myapplication.network.AplicationApiService
import com.example.myapplication.network.request.Info
import com.example.myapplication.network.request.User
import retrofit2.Call
import retrofit2.Response

class UserPresenter(view: View) {
    val maintView = view
    fun aboutUser(id: Int) {
        if (id == 0) {
            maintView.showError("User does not exist!!")
        } else {
            val apiService = AplicationApiService.create().getUser(id)
            apiService.enqueue(object : retrofit2.Callback<Info> {
                override fun onFailure(call: Call<Info>, t: Throwable) {
                    maintView.showError(t.message.toString())
                }

                override fun onResponse(call: Call<Info>, response: Response<Info>) {
                    maintView.showUserInfo(response.body()?.data)
                }

            })
        }
    }

    interface View {
        fun showError(error: String)
        fun showUserInfo(user: User?)
    }
}