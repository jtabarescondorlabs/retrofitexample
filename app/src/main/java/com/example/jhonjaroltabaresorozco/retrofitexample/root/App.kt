package com.example.jhonjaroltabaresorozco.retrofitexample.root

import android.app.Application
import com.example.jhonjaroltabaresorozco.retrofitexample.http.ApiModule

class App : Application(){

    lateinit var applicationComponent: ApplicationComponent

    // For construct first time commend this block
    private fun initDagger(app: App): ApplicationComponent =
            DaggerApplicationComponent.builder()
                    .applicationModule(ApplicationModule(app))
                    .apiModule(ApiModule())
                    .build()

    override fun onCreate() {
        super.onCreate()
        applicationComponent = initDagger(this)
    }

}