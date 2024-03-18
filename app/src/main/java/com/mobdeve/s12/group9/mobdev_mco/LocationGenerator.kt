package com.mobdeve.s12.group9.mobdev_mco

import com.mobdeve.s12.group9.mobdev_mco.Model.LocationModel

class LocationGenerator {
    companion object {
        fun loadData(): ArrayList<LocationModel> {
            val data = ArrayList<LocationModel>()

            data.add(
                LocationModel(
                "Ayala Malls Manila Bay",
                R.drawable.ayalamalls
            )
            )

            data.add(
                LocationModel(
                "Glorietta 4",
                R.drawable.glorietta
            )
            )

            return data
        }
    }
}