package com.example.jhonjaroltabaresorozco.retrofitexample.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.jhonjaroltabaresorozco.retrofitexample.R
import com.example.jhonjaroltabaresorozco.retrofitexample.http.SportsAPI
import com.example.jhonjaroltabaresorozco.retrofitexample.http.apimodel.Sports
import com.example.jhonjaroltabaresorozco.retrofitexample.root.App
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var api: SportsAPI

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as App).applicationComponent.inject(this)

        val call = api.getAllSports()

        call.enqueue(object : Callback<Sports> {
            override fun onResponse(call: Call<Sports>, response: Response<Sports>) {
                val gameList = response.body()?.sports

                for (top in gameList!!) {
                    System.out.println(top.strSport)
                }
            }

            override fun onFailure(call: Call<Sports>, t: Throwable) {
                t.printStackTrace()
            }
        })

    }

}