package com.mobdeve.s12.group9.mobdev_mco.Model

class ReservationModel {
    var id: Int = 0
        private set
    var location: String
        private set
    var date: String
        private set
    var time: String
        private set
    constructor(id: Int, location: String, date: String, time: String) {
        this.id = id
        this.location = location
        this.date = date
        this.time = time
    }

    constructor(location: String, date: String, time: String) {
        this.location = location
        this.date = date
        this.time = time
    }
}