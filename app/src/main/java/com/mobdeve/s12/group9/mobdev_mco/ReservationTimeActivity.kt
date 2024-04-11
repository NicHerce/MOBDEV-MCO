package com.mobdeve.s12.group9.mobdev_mco

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.mobdeve.s12.group9.mobdev_mco.Adapter.SpinnerAdapter
import com.mobdeve.s12.group9.mobdev_mco.databinding.ActivityReservationBinding

class ReservationTimeActivity : AppCompatActivity() {
    companion object {
        const val startTimeKey: String = "START_TIME_KEY"
        const val endTimeKey: String = "END_TIME_KEY"
        const val isOvernightKey: String = "IS_OVERNIGHT_KEY"
    }

    private lateinit var reservationBinding: ActivityReservationBinding
    private val startTime: Spinner? = null
    private val endTime: Spinner? = null
    private var spinnerAdapter: SpinnerAdapter? = null
    private var tvSpinEntry: TextView? = null

//    private val paymentPageSlotLauncher = registerForActivityResult(
//        ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
//        if (result.resultCode == RESULT_OK) {
//            val time: Int = result.data?.getIntExtra(PaymentPageActivity.timeKey, 0)!!
//            val imageId: Int = result.data?.getIntExtra(PaymentPageActivity.imageIdKey, 0)!!
//            val position: Int = result.data?.getIntExtra(PaymentPageActivity.positionKey, 0)!!
//            val isOverNight: Boolean = result.data?.getBooleanExtra(PaymentPageActivity.)
//
//        }
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        reservationBinding = ActivityReservationBinding.inflate(layoutInflater)
        setContentView(reservationBinding.root)

        val arrayStructures = resources.getStringArray(R.array.array_time)
        this.spinnerAdapter = SpinnerAdapter(this, R.layout.spinner_item, arrayStructures)
        reservationBinding.startTime.adapter = this.spinnerAdapter
        reservationBinding.endTime.adapter = this.spinnerAdapter
//        this.endTime?.adapter = this.spinnerAdapter
//
        val intent: Intent = Intent()
        reservationBinding.startTime.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>?,
                selectedItemView: View,
                position: Int,
                id: Long
            ) {
                setStartTime();
                Log.d("Reservation Activity", "test time" + tvSpinEntry?.text.toString())
                intent.putExtra(ReservationTimeActivity.startTimeKey, tvSpinEntry?.text.toString())
            }

            override fun onNothingSelected(parentView: AdapterView<*>?) {}
        }

        reservationBinding.endTime.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>?,
                selectedItemView: View,
                position: Int,
                id: Long
            ) {
                setEndTime();
                intent.putExtra(ReservationTimeActivity.endTimeKey, tvSpinEntry?.text.toString())
            }

            override fun onNothingSelected(parentView: AdapterView<*>?) {}
        }

        reservationBinding.reservationBtn.setOnClickListener(View.OnClickListener {
            Log.d("Reservation Activity", "intent = " + intent.getStringExtra(startTimeKey))
            setResult(Activity.RESULT_OK, intent)
            finish()
        })

//        val name: String = intent.getStringExtra(ReserveLocationActivity.nameKey)!!
//        val imageId: Int = intent.getIntExtra(ReserveLocationActivity.imageIdKey, 0)
//        val time: String = intent.getLongExtra(ReserveLocationActivity.timeKey, 0)
//        val position: Int = intent.getIntExtra(ReserveLocationActivity.positionKey, 0)
//        Log.d(TAG, "reservation activity date and time = " + dateAndTime.toString())
//        intent.getLongExtra(ReserveLocationActivity.dateAndTimeKey, 0)
//        intent.getIntExtra(ReserveLocationActivity.positionKey, 0)
//        val name: String = result.data?.getStringExtra(ReserveLocationActivity.nameKey)!!
//        val imageId: Int = result.data?.getIntExtra(ReserveLocationActivity.imageIdKey, 0)!!
//        val position: Int = result.data?.getIntExtra(ReserveLocationActivity.positionKey, 0)!!

//        intent.putExtra(timeKey, this.tvSpinEntry.text.toString())

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

    private fun setStartTime() {
        this.tvSpinEntry = reservationBinding.startTime.selectedView?.findViewById<TextView>(R.id.tv_spinner_entry)
    }
    private fun setEndTime() {
        this.tvSpinEntry = reservationBinding.endTime.selectedView?.findViewById<TextView>(R.id.tv_spinner_entry)
    }
}