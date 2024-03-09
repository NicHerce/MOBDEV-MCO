package com.mobdeve.s12.group9.mobdev_mco

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.mobdeve.s12.group9.mobdev_mco.databinding.ActivityViewAvailableSlotsPageBinding

class ViewAvailableSlotsPageActivity : AppCompatActivity() {
    companion object {
        const val TAG: String = "Main Activity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewAvailableSlotsViewBinding: ActivityViewAvailableSlotsPageBinding = ActivityViewAvailableSlotsPageBinding.inflate(layoutInflater)
        setContentView(viewAvailableSlotsViewBinding.root)

        Log.d(TAG, "onCreate finished execution")
    }
}