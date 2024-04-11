package com.mobdeve.s12.group9.mobdev_mco.Database

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import com.mobdeve.s12.group9.mobdev_mco.Model.ReservationModel

class ReservationDatabase(context: Context) {
    // A private instance of the DB helper
    private lateinit var reservationDatabaseHandler: ReservationDatabaseHandler

    // Initializes the databaseHandler instance using the context provided.
    init {
        this.reservationDatabaseHandler = ReservationDatabaseHandler(context)
    }

    // Add a reservation and return id
    fun addReservation(reservation: ReservationModel) {
        val db = reservationDatabaseHandler.writableDatabase

        val contentValues = ContentValues()
        contentValues.put(ReservationDatabaseHandler.RESERVATION_LOCATION, reservation.location)
        contentValues.put(ReservationDatabaseHandler.RESERVATION_DATE, reservation.date)
        contentValues.put(ReservationDatabaseHandler.RESERVATION_TIME, reservation.time)

        val id = db.insert(ReservationDatabaseHandler.RESERVATION_TABLE, null, contentValues)

        contentValues.put(ReservationDatabaseHandler.RESERVATION_ID, id)
        db.close()
    }

    //Update a reservation
    fun updateReservation(reservation: ReservationModel) {
        val db = reservationDatabaseHandler.writableDatabase

        val contentValues = ContentValues()
        contentValues.put(ReservationDatabaseHandler.RESERVATION_LOCATION, reservation.location)
        contentValues.put(ReservationDatabaseHandler.RESERVATION_DATE, reservation.date)
        contentValues.put(ReservationDatabaseHandler.RESERVATION_TIME, reservation.time)

//        db.update(DatabaseHandler.RESERVATION_TABLE, contentValues, DatabaseHandler.RESERVATION_ID + " =?", arrayOf(media.title))


        db.close()
    }

    //Delete a reservation
    fun deleteReservation(reservation: ReservationModel) {
        val db = reservationDatabaseHandler.writableDatabase

//        db.delete(DatabaseHandler.RESERVATION_TABLE, DatabaseHandler.RESERVATION_ID + " =?", arrayOf(media.title))

        db.close()
    }

    //Get reservation details
    fun getReservation(): ArrayList<ReservationModel>{
        val db: SQLiteDatabase = reservationDatabaseHandler.writableDatabase

        val c : Cursor = db.query(
            ReservationDatabaseHandler.RESERVATION_TABLE,
            null,
            null,
            null,
            null,
            null,
            null,
            null
        )

        val result = ArrayList<ReservationModel>()

        while(c.moveToNext()) {
            result.add(ReservationModel(
                c.getInt(c.getColumnIndexOrThrow(ReservationDatabaseHandler.RESERVATION_ID)),
                c.getString(c.getColumnIndexOrThrow(ReservationDatabaseHandler.RESERVATION_LOCATION)),
                c.getString(c.getColumnIndexOrThrow(ReservationDatabaseHandler.RESERVATION_DATE)),
                c.getString(c.getColumnIndexOrThrow(ReservationDatabaseHandler.RESERVATION_TIME))
            ))
        }

        c.close()
        db.close()

        return result
    }
}