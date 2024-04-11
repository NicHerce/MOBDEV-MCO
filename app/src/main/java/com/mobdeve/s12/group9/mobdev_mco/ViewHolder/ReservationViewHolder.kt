package com.mobdeve.s12.group9.mobdev_mco.ViewHolder

import androidx.recyclerview.widget.RecyclerView
import com.mobdeve.s12.group9.mobdev_mco.Model.ReservationModel
import com.mobdeve.s12.group9.mobdev_mco.databinding.ReservationsLayoutBinding // LocationsLayoutBinding

class ReservationViewHolder(private val viewBinding: ReservationsLayoutBinding): RecyclerView.ViewHolder(viewBinding.root) {
    // Performs the binding of the email data to the views in the ViewHolder
    fun bindData(reservationModel: ReservationModel) {
//        this.viewBinding.tvReservationStatus.text   = reservationModel.status
        this.viewBinding.tvReservationLocation.text = reservationModel.location
        this.viewBinding.tvReservationDate.text     = reservationModel.date
        this.viewBinding.tvReservationTime.text     = reservationModel.time
//        this.viewBinding.tvDurationStatus.text      = reservationModel.timeStatus
    }
}
