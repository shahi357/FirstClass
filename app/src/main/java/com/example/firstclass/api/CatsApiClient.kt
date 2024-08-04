package com.example.firstclass.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CatsApiClient {
    fun getCatsApiService(): CatsService {
        val client = Retrofit
            .Builder()
            .baseUrl("https://freetestapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
        return client.create(CatsService::class.java)
    }
}