package com.mobdeve.s12.group9.mobdev_mco

class LocationGenerator {
    companion object {
        fun loadData(): ArrayList<Location> {
            val data = ArrayList<Location>()

            data.add(Location(
                "Ayala Malls Manila Bay",
                R.drawable.ayalamalls
            ))

            data.add(Location(
                "Glorietta 4",
                R.drawable.glorietta
            ))

            return data
        }
    }
}