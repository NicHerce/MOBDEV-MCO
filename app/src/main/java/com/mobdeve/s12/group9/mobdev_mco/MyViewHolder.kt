package com.mobdeve.s12.group9.mobdev_mco

import androidx.recyclerview.widget.RecyclerView
import com.mobdeve.s12.group9.mobdev_mco.databinding.LocationsLayoutBinding

class MyViewHolder(private val viewBinding: LocationsLayoutBinding): RecyclerView.ViewHolder(viewBinding.root) {
    // Performs the binding of the email data to the views in the ViewHolder
    fun bindData(locationModel: LocationModel) {
        this.viewBinding.ivLocationImg.setImageResource(locationModel.imageID)
        this.viewBinding.tvLocationName.text = locationModel.name
    }
}
