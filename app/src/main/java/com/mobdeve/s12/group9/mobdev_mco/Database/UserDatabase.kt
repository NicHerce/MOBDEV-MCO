package com.mobdeve.s12.group9.mobdev_mco.Database

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.service.autofill.UserData
import com.mobdeve.s12.group9.mobdev_mco.Model.UserModel

class UserDatabase(context: Context) {

    private lateinit var userDatabaseHandler: UserDatabaseHandler

    init {
        this.userDatabaseHandler = UserDatabaseHandler(context)
    }

    fun addUser(user: UserModel): Long? {
        val db = userDatabaseHandler.writableDatabase

        val contentValues = ContentValues()

        contentValues.put(UserModel.USERNAME, user.username)
        contentValues.put(UserModel.EMAIL, user.email)
        contentValues.put(UserModel.PASSWORD, user.password) // Unhashed text password lmao, I'm not bothering with it
        contentValues.put(UserModel.LICENSE_ID, user.license_id)
        contentValues.put(UserModel.PLATE_NO, user.plate_no)

        val id = db?.insert(UserModel.TABLE_NAME, null, contentValues)

        db.close()

        return id
    }

    fun checkPassword(email: String, password: String): Boolean {
        val db = userDatabaseHandler.readableDatabase

        // Query to find the user with the same id as the user argument
        val c: Cursor = db.query(
            UserModel.TABLE_NAME,
            arrayOf(UserModel.PASSWORD),   // Limit to only getting password
            "${UserModel.EMAIL} = ?",     // Where ID = id of argument
            arrayOf(email),
            null,
            null,
            null,
            null
        )

        // Since query starts cursor always at -1 index, move one index forward
        c.moveToNext()

        val ret = c.getString(0) == password

        db.close()
        c.close()

        return ret
    }

    companion object {
        fun checkPassword(email: String, password: String): Boolean {
            return checkPassword(email, password)
        }
    }

}