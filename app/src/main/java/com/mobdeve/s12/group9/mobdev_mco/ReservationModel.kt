package com.mobdeve.s12.group9.mobdev_mco

class ReservationModel (
    val status:     String,
    val location:   String,
    val date:       String, // this can be LocalDate variable with the format: YYYY-MM-DD
    val time:       String, // this can be LocalTime variable with the format: HH:MM
    val timeStatus: String
)