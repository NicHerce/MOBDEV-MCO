package com.mobdeve.s12.group9.mobdev_mco

import androidx.recyclerview.widget.RecyclerView
import com.mobdeve.s12.group9.mobdev_mco.databinding.LocationsLayoutBinding

class MyViewHolder(private val viewBinding: LocationsLayoutBinding): RecyclerView.ViewHolder(viewBinding.root) {
    // Performs the binding of the email data to the views in the ViewHolder
    fun bindData(location: Location) {
        this.viewBinding.ivLocationImg.setImageResource(location.imageID)
        this.viewBinding.tvLocationName.text = location.name
    }
}
