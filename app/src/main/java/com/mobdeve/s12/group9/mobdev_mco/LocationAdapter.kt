package com.mobdeve.s12.group9.mobdev_mco

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.activity.result.ActivityResultLauncher
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.mobdeve.s12.group9.mobdev_mco.databinding.LocationsLayoutBinding

// Adapter is an Abstract class
// Adapter requires 3 functions: onCreateViewHolder, onBindViewHolder, and getItemCount
class LocationAdapter(
        private val data: ArrayList<LocationModel>,
        private val reserveLocationSlotLauncher: ActivityResultLauncher<Intent>
    ) : Adapter<LocationViewHolder>() {
    companion object {
        const val TAG: String = "My Adapter"
        const val nameKey : String = "NAME_KEY"
        const val imageIdKey : String = "IMAGE_ID_KEY"
        const val positionKey: String = "POSITION_KEY"
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationViewHolder {
        // Initialize the ViewBinding of an item's layout
        val itemViewBinding: LocationsLayoutBinding = LocationsLayoutBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        val locationViewHolder = LocationViewHolder(itemViewBinding)

        LocationViewHolder(itemViewBinding).itemView.setOnClickListener{
            val intent = Intent(locationViewHolder.itemView.context, ReserveLocationActivity::class.java)

            Log.d(TAG, "name =" + itemViewBinding.tvLocationName.text.toString())
            intent.putExtra(ReserveLocationActivity.nameKey, itemViewBinding.tvLocationName.text.toString())
            Log.d(TAG, "id =" + itemViewBinding.ivLocationImg.id)
//            2131230962
            intent.putExtra(ReserveLocationActivity.imageIdKey, 2131165306)
            intent.putExtra(ReserveLocationActivity.positionKey, myViewHolder.adapterPosition)

            this.reserveLocationSlotLauncher.launch(intent)
        }

        return locationViewHolder
    }

    override fun onBindViewHolder(holder: LocationViewHolder, position: Int) {
        holder.bindData(data[position])
    }
    override fun getItemCount(): Int {
        return data.size
    }
}