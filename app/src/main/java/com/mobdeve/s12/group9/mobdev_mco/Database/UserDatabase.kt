package com.mobdeve.s12.group9.mobdev_mco.Database

import android.content.Context
import com.mobdeve.s12.group9.mobdev_mco.Model.UserModel

class UserDatabase(context: Context) {

    private lateinit var  databaseHandler: DatabaseHandler

    init {
        this.databaseHandler = DatabaseHandler(context)
    }

//    fun addUser(user: UserModel): Int {
//
//    }

}