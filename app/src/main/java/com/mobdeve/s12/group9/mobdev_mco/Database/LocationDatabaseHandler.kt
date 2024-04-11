package com.mobdeve.s12.group9.mobdev_mco.Database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import com.mobdeve.s12.group9.mobdev_mco.Model.UserModel

class LocationDatabaseHandler (context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION){

    // All constant variables needed for the database
    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "LocationDatabase"
        const val LOCATION_TABLE = "location_table"

        const val LOCATION_ID = "id"
        const val LOCATION_NAME = "location_name"
        const val LOCATION_IMAGE_ID = "location_image_id"

        private var instance: LocationDatabaseHandler? = null

        @Synchronized
        fun getInstance(context: Context): LocationDatabaseHandler? {
            if (instance == null) {
                instance = LocationDatabaseHandler(context.applicationContext)
            }
            return instance
        }
    }

    // Handles creation of the database
    override fun onCreate(db: SQLiteDatabase?) {
        Log.d("DatabaseHandler", "hi")
        val CREATE_LOCATION_TABLE = "CREATE TABLE IF NOT EXISTS " + LOCATION_TABLE + " (" +
                LOCATION_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                LOCATION_NAME + " TEXT, " +
                LOCATION_IMAGE_ID + " TEXT)"
        db?.execSQL(CREATE_LOCATION_TABLE)

        // Create User Table
        val CREATE_USER_TABLE = "CREATE TABLE IF NOT EXIST " + UserModel.TABLE_NAME + " (" +
                UserModel.ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                UserModel.EMAIL + " TEXT, " +
                UserModel.PASSWORD + " TEXT, " +
                UserModel.LICENSE_ID + " TEXT, " +
                UserModel.PLATE_NO + " TEXT, "
        db?.execSQL(CREATE_USER_TABLE)

        //Create sample user
        val values = ContentValues()
        values.put(UserModel.USERNAME, "JohnSmith")
        values.put(UserModel.EMAIL, "JohnSmith@email.com")
        values.put(UserModel.PASSWORD, "password")
        values.put(UserModel.PLATE_NO, "ABC123")
        values.put(UserModel.LICENSE_ID, "0987654321")
        db?.insert(UserModel.TABLE_NAME, null, values)
        Log.d("DatabaseHandler", "Created JohnSmith in Users")

        db?.close()

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
        db!!.execSQL("DROP TABLE IF EXISTS $LOCATION_TABLE")
        onCreate(db)
    }
}