package com.example.firstclass.api

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface CatsService {

    @GET("api/v1/cats")
    fun getCats(): Call<List<Cats>>

//    @POST("api/v1/login")
//    fun login(@Field("username") username: String, @Field("password") password: String ): Call<LoginResponse>
}
