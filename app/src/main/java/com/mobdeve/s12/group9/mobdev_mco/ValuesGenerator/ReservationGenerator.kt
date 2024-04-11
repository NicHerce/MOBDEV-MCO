package com.mobdeve.s12.group9.mobdev_mco.ValuesGenerator

import com.mobdeve.s12.group9.mobdev_mco.Model.ReservationModel

class ReservationGenerator {
    companion object {
        fun loadData(): ArrayList<ReservationModel> {
            val data = ArrayList<ReservationModel>()

            // On-going reservation
            data.add(
                ReservationModel(
                "Ayala Malls Manila Bay",
                "January 01, 2024",
                "12:00pm - 5:30pm",
            )
            )

            // Up-coming reservation
            data.add(
                ReservationModel(
                "Glorietta 4",
                "January 08, 2024",
                "6:00pm - 9:00pm",
            )
            )

            return data
        }
    }
}