package com.mobdeve.s12.group9.mobdev_mco.Database

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import com.mobdeve.s12.group9.mobdev_mco.Model.LocationModel

class LocationDatabase(context: Context) {
    // A private instance of the DB helper
    private lateinit var locationDatabaseHandler : LocationDatabaseHandler

    // Initializes the databaseHandler instance using the context provided.
    init {
        this.locationDatabaseHandler = LocationDatabaseHandler(context)
    }

    // Add a location and return id
    fun addLocation(location: LocationModel) : Int {
        val db = locationDatabaseHandler.writableDatabase

        val contentValues = ContentValues()
        contentValues.put(LocationDatabaseHandler.LOCATION_NAME, location.name)
        contentValues.put(LocationDatabaseHandler.LOCATION_IMAGE_ID, location.imageID)

        val id = db.insert(LocationDatabaseHandler.LOCATION_TABLE, null, contentValues)

        db.close()

        return id.toInt()
    }

    //Update a location
    fun updateLocation(location: LocationModel) {
        val db = locationDatabaseHandler.writableDatabase

        val contentValues = ContentValues()
        contentValues.put(LocationDatabaseHandler.LOCATION_NAME, location.name)
        contentValues.put(LocationDatabaseHandler.LOCATION_IMAGE_ID, location.imageID)

//        db.update(DatabaseHandler.LOCATION_TABLE, contentValues, DatabaseHandler.LOCATION_ID + " =?", arrayOf(media.title))


        db.close()
    }

    //Delete a location
    fun deleteLocation(location: LocationModel) {
        val db = locationDatabaseHandler.writableDatabase

//        db.delete(DatabaseHandler.LOCATION_TABLE, DatabaseHandler.LOCATION_ID + " =?", arrayOf(media.title))

        db.close()
    }

    //Get location details
    fun getLocation(): ArrayList<LocationModel>{
        val db: SQLiteDatabase = locationDatabaseHandler.writableDatabase

        val c : Cursor = db.query(
            LocationDatabaseHandler.LOCATION_TABLE,
            null,
            null,
            null,
            null,
            null,
            null,
            null
        )

        val result = ArrayList<LocationModel>()

        while(c.moveToNext()) {
            result.add(LocationModel(
                c.getInt(c.getColumnIndexOrThrow(LocationDatabaseHandler.LOCATION_ID)),
                c.getString(c.getColumnIndexOrThrow(LocationDatabaseHandler.LOCATION_NAME)),
                c.getInt(c.getColumnIndexOrThrow(LocationDatabaseHandler.LOCATION_IMAGE_ID)),
            ))
        }

        c.close()
        db.close()

        return result
    }
}