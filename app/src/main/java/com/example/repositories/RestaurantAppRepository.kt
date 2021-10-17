package com.example.repositories


import androidx.room.withTransaction
import com.example.data.RestaurantAppDao
import com.example.data.RestaurantDatabase
import com.example.network.ApiCalls
import com.example.utils.networkBoundResource
import javax.inject.Inject

class RestaurantAppRepository @Inject constructor(
    private val restaurantAppDao: RestaurantAppDao,
    private val apiCalls: ApiCalls,
    private val restaurantDatabase: RestaurantDatabase
){
    fun getAllRestaurants() = networkBoundResource(

        query = {
            restaurantAppDao.getAllFromDatabase()
        },
        fetch = {
            apiCalls.getAllItems(10)
        },
        saveFetchResult = {
            restaurantDatabase.withTransaction{
                restaurantAppDao.deleteFromDataBase()
                restaurantAppDao.insertIntoDataBase(it)
            }
        }
    )
}