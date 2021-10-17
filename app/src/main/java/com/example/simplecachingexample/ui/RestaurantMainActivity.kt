package com.example.simplecachingexample.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.data.RestaurantEntity
import com.example.simplecachingexample.databinding.ActivityMainBinding
import com.example.simplecachingexample.ui.adapters.RestaurantListAdapter
import com.example.simplecachingexample.ui.viewmodels.RestaurantListViewModel
import com.example.utils.Resource
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class RestaurantMainActivity : AppCompatActivity() {

    val viewModel:RestaurantListViewModel by viewModels()
    private lateinit var binding:ActivityMainBinding
    private val restaurantAdapter:RestaurantListAdapter = RestaurantListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.itemListRecyclerView.apply {
            layoutManager= LinearLayoutManager(this@RestaurantMainActivity)
            adapter=restaurantAdapter
        }

        viewModel.restaurants.observe(this,{
            val data = it.data
            data?.let{ list->
                restaurantAdapter.items=list
            }

            binding.progressBar.isVisible =  it is Resource.Loading && it.data.isNullOrEmpty()
            binding.errorText.isVisible = it is Resource.Error && it.data.isNullOrEmpty()
            

        })


    }
}