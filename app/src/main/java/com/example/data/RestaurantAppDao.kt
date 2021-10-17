package com.example.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface RestaurantAppDao {

    @Query("select * from restaurant_table")
    fun getAllFromDatabase():Flow<List<RestaurantEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertIntoDataBase(restaurants:List<RestaurantEntity>)

    @Query("delete from restaurant_table ")
    suspend fun deleteFromDataBase()
}