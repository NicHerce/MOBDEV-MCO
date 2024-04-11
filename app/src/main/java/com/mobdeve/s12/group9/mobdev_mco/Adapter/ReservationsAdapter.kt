package com.mobdeve.s12.group9.mobdev_mco.Adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.mobdeve.s12.group9.mobdev_mco.Model.ReservationModel
import com.mobdeve.s12.group9.mobdev_mco.ReservationDetailsActivity
import com.mobdeve.s12.group9.mobdev_mco.ReserveLocationActivity
import com.mobdeve.s12.group9.mobdev_mco.ViewHolder.ReservationViewHolder
import com.mobdeve.s12.group9.mobdev_mco.databinding.ReservationsLayoutBinding

// Adapter is an Abstract class
// Adapter requires 3 functions: onCreateViewHolder, onBindViewHolder, and getItemCount
class ReservationsAdapter(
        private val data: ArrayList<ReservationModel>,
        private val reservationDetailsLauncher: ActivityResultLauncher<Intent>
    ) : Adapter<ReservationViewHolder>() {
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

//        val reservationViewHolder = ReservationViewHolder(itemViewBinding)
//
//        reservationViewHolder.itemView.setOnClickListener{
//            val intent = Intent(reservationViewHolder.itemView.context, ReservationDetailsActivity::class.java)
//
//            intent.putExtra(ReservationDetailsActivity.reservationIDKey, reservationViewHolder.adapterPosition)
//
//            this.reservationDetailsLauncher.launch(intent)
//        }

        return ReservationViewHolder(itemViewBinding)
    }

    override fun onBindViewHolder(holder: ReservationViewHolder, position: Int) {
        holder.bindData(data[position])

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, ReservationDetailsActivity::class.java)

            intent.putExtra(ReservationDetailsActivity.reservationIDKey, holder.adapterPosition)

            this.reservationDetailsLauncher.launch(intent)
        }
    }
    override fun getItemCount(): Int {
        return data.size
    }
}