package com.mobdeve.s12.group9.mobdev_mco

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.mobdeve.s12.group9.mobdev_mco.databinding.LocationsLayoutBinding

// Adapter is an Abstract class
// Adapter requires 3 functions: onCreateViewHolder, onBindViewHolder, and getItemCount
class MyAdapter(private val data: ArrayList<Location>) : Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        // Initialize the ViewBinding of an item's layout
        val itemViewBinding: LocationsLayoutBinding = LocationsLayoutBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return MyViewHolder(itemViewBinding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindData(data[position])
    }
    override fun getItemCount(): Int {
        return data.size
    }
}