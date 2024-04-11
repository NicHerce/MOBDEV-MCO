package com.mobdeve.s12.group9.mobdev_mco

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.mobdeve.s12.group9.mobdev_mco.databinding.ActivityReserveLocationBinding


class ReserveLocationActivity : AppCompatActivity() {
    companion object {
        const val TAG: String = "Reserve Location Activity"
        const val nameKey: String = "NAME_KEY"
        const val imageIdKey: String = "IMAGE_ID_KEY"
        const val dateKey: String = "DATE_AND_TIME_KEY"
        const val positionKey: String = "POSITION_KEY"
        const val startTimeKey: String = "START_TIME_KEY"
        const val endTimeKey: String = "END_TIME_KEY"
        const val isOvernightKey: String = "IS_OVERNIGHT_KEY"
    }

    private lateinit var nameString: String
    private lateinit var bodyString: String
    private lateinit var startTime: String
    private lateinit var endTime: String
    private lateinit var date: String
    private var isOvernight = false;

    private lateinit var reserveLocationBinding: ActivityReserveLocationBinding   // Holds the views of the ActivityViewNoteBinding

    private val reservationSlotLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
        // Check to see if the result returned is appropriate (i.e. OK)
        Log.d(TAG, "reservation slot launcher")

        if (result.resultCode == RESULT_OK) {
            startTime = result.data?.getStringExtra(ReservationTimeActivity.startTimeKey)!!
            endTime = result.data?.getStringExtra(ReservationTimeActivity.endTimeKey)!!
            isOvernight = result.data?.getBooleanExtra(ReservationTimeActivity.isOvernightKey, false)!!
            Log.d(TAG, "start =" + startTime)
            Log.d(TAG, "end =" + endTime)
            intent.putExtra(startTimeKey, startTime)
            intent.putExtra(endTimeKey, endTime)
            intent.putExtra(isOvernightKey, isOvernight)
            Log.d(TAG, "date checking again" + date)
            intent.putExtra(dateKey, date)

            setResult(Activity.RESULT_OK, intent)
            finish()
        } else {
            Log.d(TAG, "help me")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.reserveLocationBinding = ActivityReserveLocationBinding.inflate(layoutInflater)
        setContentView(reserveLocationBinding.root)

        Log.d(TAG, intent.getStringExtra(ReserveLocationActivity.nameKey).toString())
        reserveLocationBinding.tvLocationName.setText(intent.getStringExtra(ReserveLocationActivity.nameKey))
        Log.d(
            TAG,
            "reserve location id 2 =" + intent.getIntExtra(ReserveLocationActivity.imageIdKey, 0)
        )
//        2131230962
//        reserveLocationBinding.locationImageTv.setImageResource(
//            intent.getIntExtra(
//                ReserveLocationActivity.imageIdKey,
//                0
//            )
//        )
        val position = intent.getIntExtra(ReserveLocationActivity.positionKey, 0)
        reserveLocationBinding.reserveBtn.setOnClickListener(View.OnClickListener {
//            reserveLocationBinding.locationCalendarReservationCv.setOnDateChangeListener(OnDateChangeListener { arg0, year, month, date ->
//                val dateAndTime = Toast.makeText(
//                    applicationContext,
//                    "$date/$month/$year",
//                    4000
//                ).show()
//            })
//            val intent: Intent = Intent()
            val intent: Intent = Intent(this@ReserveLocationActivity, ReservationTimeActivity::class.java)

            intent.putExtra(
                nameKey,
                reserveLocationBinding.tvLocationName.text.toString()
            )
            intent.putExtra(
                imageIdKey,
                reserveLocationBinding.locationImageTv.id
            )
            date = reserveLocationBinding.locationCalendarReservationCv.date.toString()
            Log.d(TAG, "date check" + intent.getStringExtra(ReserveLocationActivity.dateKey))
            intent.putExtra(positionKey, position)

            this.reservationSlotLauncher.launch(intent)

//            Log.d(
//                TAG,
//                "Reserve Location =" + reserveLocationBinding.locationCalendarReservationCv.date
//            )
        })

        reserveLocationBinding.locationsBtn.setOnClickListener {
            val intent = Intent(this, LocationActivity::class.java)
            startActivity(intent)
            finish()
        }

        reserveLocationBinding.viewReservationsBtn.setOnClickListener {
            val intent = Intent(this, ReservationsActivity::class.java)
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