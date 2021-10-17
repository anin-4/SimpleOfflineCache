package com.example.simplecachingexample.ui.viewmodels

import androidx.lifecycle.*
import com.example.data.RestaurantEntity
import com.example.network.ApiCalls
import com.example.repositories.RestaurantAppRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RestaurantListViewModel @Inject constructor(
    private val restaurantAppRepository: RestaurantAppRepository
):ViewModel() {

    val restaurants = restaurantAppRepository.getAllRestaurants().asLiveData()

//    private var _items= MutableLiveData<List<RestaurantEntity>>()
//    val items:LiveData<List<RestaurantEntity>>
//    get() = _items
//
//    init {
//        getItems()
//    }
//
//    private fun getItems(){
//        viewModelScope.launch {
//            val response=networkCall.getAllItems(10)
//            _items.value= response
//            delay(200)
//        }
//    }

}