package com.example.myapplication.home

import android.content.Context
import com.example.myapplication.AppSharedPreferences
import com.example.myapplication.R
import com.example.myapplication.network.AplicationApiService
import com.example.myapplication.network.Token
import com.example.myapplication.network.request.LoginRequest
import retrofit2.Call
import retrofit2.Response


class HomePresenter(view: View) {
    private var mainView = view
    fun checkEmailPassword(email: String, pass: String, context: Context) {
        if (email.isEmpty() || pass.isEmpty()) {
            mainView.showError(context.getString(R.string.empty))
        } else {
           val apiService = AplicationApiService.create()
                apiService.login(LoginRequest(email, pass))
                    .enqueue(object : retrofit2.Callback<Token> {
                        override fun onFailure(call: Call<Token>, t: Throwable) {
                            mainView.showError(t.message.toString())
                        }

                        override fun onResponse(call: Call<Token>, response: Response<Token>) {
                            AppSharedPreferences(context).save("token", response.body()?.token)
                            if (response.body()?.token == null) {
                                mainView.showError(context.getString(R.string.incorrectPasswordEmail))
                            } else {
                                response.body()?.token
                                mainView.nextPage()
                            }
                        }

                    })
        }
    }

    interface View {
        fun showError(error: String)
        fun nextPage();
    }

}