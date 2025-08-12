package com.ruan.apihelio

import retrofit2.http.GET
import retrofit2.http.Path


interface NumbersApi {
    @GET("random?json")
    suspend fun getRandomNumber(): NumbersResponse

    @GET("random/date?json")
    suspend fun getRandomDateFact(): NumbersResponse

    @GET("random/year?json")
    suspend fun getRandomYear(): NumbersResponse

    @GET("{number}/math?json")
    suspend fun getMathFact(@Path("number") number: Int): NumbersResponse

    @GET("{number}/trivia?json")
    suspend fun getTriviaFact(@Path("number") number: Int): NumbersResponse
}