package com.mobdeve.s12.group9.mobdev_mco

class ReservationGenerator {
    companion object {
        fun loadData(): ArrayList<ReservationModel> {
            val data = ArrayList<ReservationModel>()

            // On-going reservation
            data.add(ReservationModel(
                "ON-GOING",
                "Ayala Malls Manila Bay",
                "January 01, 2024",
                "12:00pm - 5:30pm",
                "TIME LEFT: 1hr 30mins"
            ))

            // Up-coming reservation
            data.add(ReservationModel(
                "UP-COMING",
                "Glorietta 4",
                "January 08, 2024",
                "6:00pm - 9:00pm",
                "Starts in: 7 Days"
            ))

            return data
        }
    }
}