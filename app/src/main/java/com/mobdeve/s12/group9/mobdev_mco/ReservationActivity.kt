package com.mobdeve.s12.group9.mobdev_mco

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.mobdeve.s12.group9.mobdev_mco.databinding.ActivityReservationBinding
import com.mobdeve.s12.group9.mobdev_mco.databinding.ActivityReserveLocationBinding

class ReservationActivity : AppCompatActivity() {
    companion object {
        const val TAG : String = "Reserve Location Activity"
        const val nameKey : String = "NAME_KEY"
        const val imageIdKey : String = "IMAGE_ID_KEY"
        const val positionKey: String = "POSITION_KEY"
    }
    private lateinit var reservationBinding: ActivityReservationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        reservationBinding = ActivityReservationBinding.inflate(layoutInflater)
        setContentView(reservationBinding.root)

        val name: String = intent.getStringExtra(ReserveLocationActivity.nameKey)!!
        val imageId: Int = intent.getIntExtra(ReserveLocationActivity.imageIdKey, 0)
        val dateAndTime: Long = intent.getLongExtra(ReserveLocationActivity.dateAndTimeKey, 0)
        val position: Int = intent.getIntExtra(ReserveLocationActivity.positionKey, 0)
        Log.d(TAG, "reservation activity date and time = " + dateAndTime.toString())
//        intent.getLongExtra(ReserveLocationActivity.dateAndTimeKey, 0)
//        intent.getIntExtra(ReserveLocationActivity.positionKey, 0)
//        val name: String = result.data?.getStringExtra(ReserveLocationActivity.nameKey)!!
//        val imageId: Int = result.data?.getIntExtra(ReserveLocationActivity.imageIdKey, 0)!!
//        val position: Int = result.data?.getIntExtra(ReserveLocationActivity.positionKey, 0)!!

        reservationBinding.locationsBtn.setOnClickListener {
            val intent = Intent(this, LocationActivity::class.java)
            startActivity(intent)
            finish()
        }

        reservationBinding.viewReservationsBtn.setOnClickListener {
            val intent = Intent(this, ReservationsActivity::class.java)
            startActivity(intent)
            finish()
        }

        reservationBinding.profileBtn.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}