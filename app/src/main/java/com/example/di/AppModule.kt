package com.example.di

import android.content.Context
import androidx.room.Room
import com.example.data.RestaurantDatabase
import com.example.network.ApiCalls
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRetrofitService() = Retrofit.Builder()
        .baseUrl("https://random-data-api.com/api/")
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
        .build()
        .create(ApiCalls::class.java)

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext app:Context) =
        Room.databaseBuilder(app,RestaurantDatabase::class.java,"restaurant_database")
            .build()

    @Singleton
    @Provides
    fun provideDao(
        database: RestaurantDatabase
    ) = database.restaurantDao()
}