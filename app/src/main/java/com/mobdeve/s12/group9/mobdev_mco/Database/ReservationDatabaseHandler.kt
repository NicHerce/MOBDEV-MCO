package com.mobdeve.s12.group9.mobdev_mco.Database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class ReservationDatabaseHandler (context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION){

    // All constant variables needed for the database
    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "ReservationDatabase.db"
        const val RESERVATION_TABLE = "reservation_table"

        const val RESERVATION_ID = "reservation_id"
        const val RESERVATION_LOCATION = "reservation_location"
        const val RESERVATION_DATE = "reservation_date"
        const val RESERVATION_TIME = "reservation_time"

        private var instance: ReservationDatabaseHandler? = null

        @Synchronized
        fun getInstance(context: Context): ReservationDatabaseHandler? {
            if (instance == null) {
                instance = ReservationDatabaseHandler(context.applicationContext)
            }
            return instance
        }
    }

    // Handles creation of the database
    override fun onCreate(db: SQLiteDatabase?) {
        Log.d("Database Handler", "hi")
        val CREATE_RESERVATION_TABLE = "CREATE TABLE IF NOT EXISTS " + RESERVATION_TABLE + " (" +
                RESERVATION_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                RESERVATION_LOCATION + " TEXT, " +
                RESERVATION_DATE + " TEXT, " +
                RESERVATION_TIME + " TEXT)"
        db?.execSQL(CREATE_RESERVATION_TABLE)

        //Insert values upon creation
//        var values = ContentValues()
//        values.put(MEDIA_ID, 1)
//        values.put(MEDIA_TITLE, "Aladin")
//        values.put(MEDIA_TYPE, "VIDEO")
//        values.put(MEDIA_DURATION, "2:08:00")
//        db?.insert(MEDIA_TABLE, null, values)
//        values = ContentValues()
    }

    //Handles the logic needed when updating the database
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS $RESERVATION_TABLE")
        onCreate(db)
    }
}