package com.ruan.apihelio

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiCliente {
    private const val BASE_URL = "http://numbersapi.com/"

    val instance: NumbersApi by lazy{
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NumbersApi::class.java)
    }
}