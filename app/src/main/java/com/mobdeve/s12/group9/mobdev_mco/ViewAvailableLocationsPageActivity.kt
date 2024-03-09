package com.mobdeve.s12.group9.mobdev_mco

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.mobdeve.s12.group9.mobdev_mco.databinding.ActivityViewAvailableLocationsPageBinding

class ViewAvailableLocationsPageActivity : AppCompatActivity() {
    companion object {
        const val TAG: String = "Main Activity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewAvailableLocationsViewBinding: ActivityViewAvailableLocationsPageBinding = ActivityViewAvailableLocationsPageBinding.inflate(layoutInflater)
        setContentView(viewAvailableLocationsViewBinding.root)

        Log.d(TAG, "onCreate finished execution")
    }
}