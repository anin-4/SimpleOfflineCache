package com.example.data

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName ="restaurant_table")
data class RestaurantEntity(
    @PrimaryKey
    val name:String,
    val type:String,
    val logo:String,
    val address:String
)