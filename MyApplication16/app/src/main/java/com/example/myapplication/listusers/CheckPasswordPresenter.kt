package com.example.myapplication.listusers

import android.content.Context
import com.example.myapplication.R
import com.example.myapplication.network.AplicationApiService
import com.example.myapplication.network.request.LoginRequest
import retrofit2.Call
import retrofit2.Response

class CheckPasswordPresenter(view: View) {
    private val view2 = view

    fun checkPassword(email: String, pass: String, context: Context) {
        if (email.isEmpty() || pass.isEmpty()) {
            view2.showPasswordError(context.getString(R.string.empty))
        } else {
            val apiService = AplicationApiService.create().login1()
            apiService.enqueue(object : retrofit2.Callback<LoginRequest> {
                override fun onFailure(call: Call<LoginRequest>, t: Throwable) {
                    view2.showPasswordError(t.message.toString())
                }

                override fun onResponse(
                    call: Call<LoginRequest>,
                    response: Response<LoginRequest>
                ) {

                    if (pass == response.body()?.password) {
                        view2.callHomePresenter(pass, email, context)
                    } else {
                        view2.showPasswordError("Incorrect password!!")
                    }
                }

            })
        }

    }

    interface View {
        fun showPasswordError(error: String)
        fun callHomePresenter(email: String, pass: String, context: Context);
    }
}