package com.mobdeve.s12.group9.mobdev_mco.ViewHolder

import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.mobdeve.s12.group9.mobdev_mco.Model.LocationModel
import com.mobdeve.s12.group9.mobdev_mco.databinding.LocationsLayoutBinding

class LocationViewHolder(private val viewBinding: LocationsLayoutBinding): RecyclerView.ViewHolder(viewBinding.root) {
    // Performs the binding of the email data to the views in the ViewHolder
    companion object {
        const val TAG: String = "View Holder"
    }
    fun bindData(locationModel: LocationModel) {
        Log.d(TAG, "image name =" + locationModel.name)
        Log.d(TAG, "image id =" + locationModel.imageID)
//        2131165306
        this.viewBinding.ivLocationImg.setImageResource(locationModel.imageID)
        this.viewBinding.tvLocationName.text = locationModel.name
    }
}
