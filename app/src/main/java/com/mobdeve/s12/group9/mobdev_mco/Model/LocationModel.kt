package com.mobdeve.s12.group9.mobdev_mco.Model

class LocationModel (val id: Int, val name: String, val imageID: Int) {
    companion object {
        private const val DEFAULT_ID = -1
    }

    constructor(name: String, imageID: Int) : this(DEFAULT_ID, name, imageID)
    constructor() : this(DEFAULT_ID, "Blank", 0)

//    init {
//        if(!mediaType.equals("AUDIO", true) and !mediaType.equals("VIDEO", true)) {
//            throw MediaItemInitializationException("Initialization of media item's mediaType must be 'Audio' or 'Video' only. Case is ignored during checking, so case variations of the Strings are allowed.")
//        }
//    }

    // Custom exception class for when the media type isn't properly provided.
//    inner class MediaItemInitializationException(message: String) : Exception(message)
}
