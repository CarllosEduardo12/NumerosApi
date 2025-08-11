package com.ruan.apihelio

import retrofit2.http.GET
import retrofit2.Call



interface NumbersApi {
    @GET("random?json")
    fun getRandomNumber(): Call<NumbersResponse>

    @GET("random/date?json")
    fun getRandomDateFact(): Call<NumbersResponse>

    @GET("random/year?json")
    fun getRandomYear(): Call<NumbersResponse>
}