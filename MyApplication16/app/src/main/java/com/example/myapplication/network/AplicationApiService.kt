package com.example.myapplication.network

import com.example.myapplication.network.request.Info
import com.example.myapplication.network.request.LoginRequest
import com.example.myapplication.network.request.User
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.*

interface AplicationApiService {

    @POST("login")
    fun login(@Body loginBody: LoginRequest): Call<Token>

    @GET("login")
    fun login1(): Call<LoginRequest>

    @GET("users")
    fun getUsers(): Call<Result>

    @GET("users/")
    fun getUser(@Query("id") id: Int): Call<Info>

    companion object {

        const val BASE_URL = "https://reqres.in/api/"

        fun create(): AplicationApiService {
            val logger = HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BODY)

            val okHttpClient = OkHttpClient
                .Builder()
                .addInterceptor(logger)
                .build()

            val retrofit = Retrofit.Builder()
                .addConverterFactory(MoshiConverterFactory.create())
                .client(okHttpClient)
                .baseUrl(BASE_URL)
                .build()

            return retrofit.create(AplicationApiService::class.java)
        }
    }
}