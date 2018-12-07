package com.example.jhonjaroltabaresorozco.retrofitexample.http

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit
import okhttp3.logging.HttpLoggingInterceptor

@Module
class ApiModule {

    val BASE_URL = "https://www.thesportsdb.com/api/v1/json/1/"

    @Provides
    fun provideClient(): OkHttpClient {

        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        return OkHttpClient.Builder().addInterceptor(interceptor).build()

    }

    @Provides
    fun provideRetrofit(baseURL: String, client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .baseUrl(baseURL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    @Provides
    fun provideApiService(): SportsAPI {
        return provideRetrofit(BASE_URL, provideClient()).create<SportsAPI>(SportsAPI::class.java!!)
    }

}