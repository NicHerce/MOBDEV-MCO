package com.mobdeve.s12.group9.mobdev_mco

class LocationGenerator {
    companion object {
        fun loadData(): ArrayList<Location> {
            val data = ArrayList<Location>()

            data.add(Location(
                "Ayala Malls by the Bay",
                R.drawable.ayalamalls
            ))

            return data
        }
    }
}