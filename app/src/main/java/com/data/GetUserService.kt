package com.data

import com.entity.UsefulActivity
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://www.boredapi.com/"

object RetrofitServices {
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    val activityApi: ActivityApi = retrofit.create(ActivityApi::class.java)
}

interface ActivityApi {
    @GET("/api/activity")
    suspend fun getActivity(): ActivityDataClass
}