package com.example.jhonjaroltabaresorozco.retrofitexample.http

import com.example.jhonjaroltabaresorozco.retrofitexample.http.apimodel.Sports
import retrofit2.Call
import retrofit2.http.GET

interface SportsAPI {

    @GET("all_sports.php")
    fun getAllSports(): Call<Sports>

}