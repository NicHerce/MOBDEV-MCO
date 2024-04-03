package com.mobdeve.s12.group9.mobdev_mco.Adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.mobdeve.s12.group9.mobdev_mco.Model.ReservationModel
import com.mobdeve.s12.group9.mobdev_mco.ReserveLocationActivity
import com.mobdeve.s12.group9.mobdev_mco.ViewHolder.ReservationViewHolder
import com.mobdeve.s12.group9.mobdev_mco.databinding.ReservationsLayoutBinding

// Adapter is an Abstract class
// Adapter requires 3 functions: onCreateViewHolder, onBindViewHolder, and getItemCount
class ReservationsAdapter(private val data: ArrayList<ReservationModel>) : Adapter<ReservationViewHolder>() {
    companion object {
        const val timeKey: String = "TIME_KEY"
        const val isOvernightKey: String = "IS_OVERNIGHT_KEY"
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReservationViewHolder {
        // Initialize the ViewBinding of an item's layout
        val itemViewBinding: ReservationsLayoutBinding = ReservationsLayoutBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        val reservationViewHolder = ReservationViewHolder(itemViewBinding)

//        ReservationViewHolder(itemViewBinding).itemView.setOnClickListener{
//            val intent = Intent(reservationViewHolder.itemView.context, ReserveLocationActivity::class.java)
//
//            intent.putExtra(ReserveLocationActivity.nameKey, itemViewBinding.tvLocationName.text.toString())
//            intent.putExtra(ReserveLocationActivity.imageIdKey, itemViewBinding.ivLocationImg.id.toString())
//            intent.putExtra(ReserveLocationActivity.positionKey, locationViewHolder.adapterPosition)
//
//            this.reserveLocationSlotLauncher.launch(intent)
//        }

        return ReservationViewHolder(itemViewBinding)
    }

    override fun onBindViewHolder(holder: ReservationViewHolder, position: Int) {
        holder.bindData(data[position])
    }
    override fun getItemCount(): Int {
        return data.size
    }
}