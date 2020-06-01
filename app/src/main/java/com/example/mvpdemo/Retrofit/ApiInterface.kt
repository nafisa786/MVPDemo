package com.example.mvpdemo.Retrofit

import com.example.mvpdemo.GenereResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface
{
    @GET("genres")
    fun generresponse(): Call<GenereResponse>
}