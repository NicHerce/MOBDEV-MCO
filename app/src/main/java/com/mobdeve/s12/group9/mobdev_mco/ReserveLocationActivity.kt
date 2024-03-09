package com.mobdeve.s12.group9.mobdev_mco

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.CalendarView.OnDateChangeListener
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.mobdeve.s12.group9.mobdev_mco.databinding.ActivityReserveLocationBinding


class ReserveLocationActivity : AppCompatActivity() {
    companion object {
        const val TAG: String = "Reserve Location Activity"
        const val nameKey: String = "NAME_KEY"
        const val imageIdKey: String = "IMAGE_ID_KEY"
        const val dateAndTimeKey: String = "DATE_AND_TIME_KEY"
        const val positionKey: String = "POSITION_KEY"
    }

    private lateinit var nameString: String
    private lateinit var bodyString: String

    private lateinit var reserveLocationBinding: ActivityReserveLocationBinding   // Holds the views of the ActivityViewNoteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.reserveLocationBinding = ActivityReserveLocationBinding.inflate(layoutInflater)
        setContentView(reserveLocationBinding.root)

        Log.d(TAG, intent.getStringExtra(ReserveLocationActivity.nameKey).toString())
        reserveLocationBinding.locationNameTv.setText(intent.getStringExtra(ReserveLocationActivity.nameKey))
        Log.d(
            TAG,
            "reserve location id 2 =" + intent.getIntExtra(ReserveLocationActivity.imageIdKey, 0)
        )
//        2131230962
        reserveLocationBinding.locationImageTv.setImageResource(
            intent.getIntExtra(
                ReserveLocationActivity.imageIdKey,
                0
            )
        )
        val position = intent.getIntExtra(ReserveLocationActivity.positionKey, 0)

        reserveLocationBinding.reserveBtn.setOnClickListener(View.OnClickListener {
//            reserveLocationBinding.locationCalendarReservationCv.setOnDateChangeListener(OnDateChangeListener { arg0, year, month, date ->
//                val dateAndTime = Toast.makeText(
//                    applicationContext,
//                    "$date/$month/$year",
//                    4000
//                ).show()
//            })
            val intent: Intent = Intent()

            intent.putExtra(
                ReserveLocationActivity.nameKey,
                reserveLocationBinding.locationNameTv.text.toString()
            )
            intent.putExtra(
                ReserveLocationActivity.imageIdKey,
                reserveLocationBinding.locationImageTv.id
            )
            intent.putExtra(
                ReserveLocationActivity.dateAndTimeKey,
                reserveLocationBinding.locationCalendarReservationCv.date
            )
            intent.putExtra(ReserveLocationActivity.positionKey, position)

            Log.d(
                TAG,
                "Reserve Location =" + reserveLocationBinding.locationCalendarReservationCv.date
            )
            setResult(Activity.RESULT_OK, intent)
            finish()
        })

        reserveLocationBinding.locationsBtn.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }

        reserveLocationBinding.viewReservationsBtn.setOnClickListener {
            val intent = Intent(this, ViewReservationsActivity::class.java)
            startActivity(intent)
            finish()
        }

        reserveLocationBinding.profileBtn.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}