package com.mobdeve.s12.group9.mobdev_mco

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.mobdeve.s12.group9.mobdev_mco.databinding.ReservationsLayoutBinding

// Adapter is an Abstract class
// Adapter requires 3 functions: onCreateViewHolder, onBindViewHolder, and getItemCount
class ReservationAdapter(private val data: ArrayList<ReservationModel>) : Adapter<ReservationViewHolder>() {
//    companion object {
//        const val nameKey : String    = "NAME_KEY"
//        const val imageIdKey : String = "IMAGE_ID_KEY"
//        const val positionKey: String = "POSITION_KEY"
//    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReservationViewHolder {
        // Initialize the ViewBinding of an item's layout
        val itemViewBinding: ReservationsLayoutBinding = ReservationsLayoutBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

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