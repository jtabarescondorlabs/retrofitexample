package com.example.jhonjaroltabaresorozco.retrofitexample.root

import com.example.jhonjaroltabaresorozco.retrofitexample.activities.MainActivity
import com.example.jhonjaroltabaresorozco.retrofitexample.http.ApiModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class, ApiModule::class])
interface ApplicationComponent {

    fun inject(target: MainActivity)

}