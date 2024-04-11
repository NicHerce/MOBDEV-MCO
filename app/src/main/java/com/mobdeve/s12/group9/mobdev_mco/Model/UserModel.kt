package com.mobdeve.s12.group9.mobdev_mco.Model

class UserModel (
                 val id: Long,
                 val username: String,
                 val email: String,
                 val password: String,
                 val license_id: String?,
                 val plate_no: String?
                )
{

    companion object {
        private const val DEFAULT_ID: Int = -1

        const val TABLE_NAME: String = "users"
        const val ID: String = "id"
        const val USERNAME: String = "username"
        const val EMAIL:String = "email"
        const val PASSWORD: String = "password"
        const val LICENSE_ID: String = "license"
        const val PLATE_NO: String = "plate"

    }

//    constructor(id: Int, username: String, email: String, password: String, license_id: String, plate_no: String): this(
//        id, username, email, password, license_id, plate_no)
//
//    constructor(id: Int, username: String, email: String, password: String): this(
//        id, username, email, password, null, null)
}