package com.example.simplecachingexample.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.data.RestaurantEntity
import com.example.simplecachingexample.databinding.RestaurantListItemBinding

class RestaurantListAdapter:RecyclerView.Adapter<RestaurantListAdapter.RestaurantListViewHolder>() {

    var items:List<RestaurantEntity> = listOf()
        set(value) {
        field=value
        notifyDataSetChanged()
    }

    class RestaurantListViewHolder(private val binding:RestaurantListItemBinding) : RecyclerView.ViewHolder(binding.root){

            fun bind(item: RestaurantEntity) {
                binding.restaurantAddress.text = item.address
                binding.restaurantName.text = item.name
                binding.restaurantType.text = item.type
                Glide.with(itemView).load(item.logo).into(binding.restaurantImage)
            }



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantListAdapter.RestaurantListViewHolder {
        val binding = RestaurantListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return RestaurantListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RestaurantListViewHolder, position: Int) {
        items[position]?.let {
            holder.bind(items[position])
        }
    }

    override fun getItemCount()= items.size

}