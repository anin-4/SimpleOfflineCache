package com.example.network

import com.example.data.RestaurantEntity
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiCalls {

    @GET("restaurant/random_restaurant")
    suspend fun getAllItems(
        @Query("size")
        size:Int=10
    ):List<RestaurantEntity>
}