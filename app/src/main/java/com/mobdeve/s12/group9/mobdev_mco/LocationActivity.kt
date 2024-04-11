package com.mobdeve.s12.group9.mobdev_mco

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SnapHelper
import com.mobdeve.s12.group9.mobdev_mco.Adapter.LocationAdapter
import com.mobdeve.s12.group9.mobdev_mco.Model.LocationModel
import com.mobdeve.s12.group9.mobdev_mco.Model.ReservationModel
import com.mobdeve.s12.group9.mobdev_mco.ValuesGenerator.LocationGenerator
import com.mobdeve.s12.group9.mobdev_mco.databinding.ActivityHomeBinding

class LocationActivity : AppCompatActivity() {
    companion object {
        const val TAG: String = "Main Activity"
//        private val details = ArrayList<ReservationModel>()
    }

    // Generate the data for Locations
    private val locationModelList: ArrayList<LocationModel> = LocationGenerator.loadData()

    private lateinit var recyclerView: RecyclerView         // RecyclerView reference
    private lateinit var locationAdapter: LocationAdapter   // Adapter reference
    private val snapHelper: SnapHelper = LinearSnapHelper() // SnapHelper reference

    // HomeActivityBinding reference
    private lateinit var homeActivityBinding: ActivityHomeBinding

    //Reservation values
    private var location = ""
    private var date = ""
    private var time = ""

    //Go to location adapter, pass result back
    private val reserveLocationSlotLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
        Log.d(TAG, "reserve location launcher")
        if (result.resultCode == RESULT_OK) {
            val name: String = result.data?.getStringExtra(ReserveLocationActivity.nameKey)!!
            val imageId: Int = result.data?.getIntExtra(ReserveLocationActivity.imageIdKey, 0)!!
            val date: Int = result.data?.getIntExtra(ReserveLocationActivity.dateKey, 0)!!
            val position: Int = result.data?.getIntExtra(ReserveLocationActivity.positionKey, 0)!!
            val startTime: String = result.data?.getStringExtra(ReserveLocationActivity.startTimeKey)!!
            val endTime: String = result.data?.getStringExtra(ReserveLocationActivity.endTimeKey)!!
            val isOvernight: Boolean = result.data?.getBooleanExtra(ReserveLocationActivity.isOvernightKey, false)!!
            val startTimeValue = startTime.split(":").toMutableList()
            val startTimeTrueValue = startTime.split(" ")
            val endTimeValue = endTime.split(":").toMutableList()
            val endTimeTrueValue = endTime.split(" ")
            var reservationPayment = 0
            if(startTimeTrueValue[1] == "PM") {
                startTimeValue[0] = (startTimeValue[0].toInt() + 12).toString()
            }
            if(endTimeTrueValue[1] == "PM") {
                endTimeValue[0] = (endTimeValue[0].toInt() + 12).toString()
            }

            var duration = endTimeValue[0].toInt() - startTimeValue[0].toInt();

            Log.d(TAG, "duration" + duration)

            if(startTimeValue[0].toInt() in 1..3) {
                if(duration >= 3) {
                    for(i in 1..3) {
                        Log.d(TAG, "Looped2")
                        duration -= 1
                        startTimeValue[0] = (startTimeValue[0].toInt() + 1).toString()
                        reservationPayment += 10
                    }
                } else {
                    for(i in 1 .. duration) {
                        Log.d(TAG, "Looped2")
                        duration -= 1
                        startTimeValue[0] = (startTimeValue[0].toInt() + 1).toString()
                        reservationPayment += 10
                    }
                }
            }

            if(startTimeValue[0].toInt() in 4..9 ) {
                duration -= 3;
                startTimeValue[0] = (startTimeValue[0].toInt() + 3).toString()
                reservationPayment += 55
                Log.d(TAG, "startTimeValue update = " + startTimeValue[0].toInt());
                Log.d(TAG, "duration" + duration)
                Log.d(TAG, "Looped1")

                if(duration >= 3) {
                    for(i in 1..3) {
                        Log.d(TAG, "Looped2")
                        duration -= 1
                        startTimeValue[0] = (startTimeValue[0].toInt() + 1).toString()
                        reservationPayment += 30
                    }
                } else {
                    for(i in 1 .. duration) {
                        Log.d(TAG, "Looped2")
                        duration -= 1
                        startTimeValue[0] = (startTimeValue[0].toInt() + 1).toString()
                        reservationPayment += 30
                    }
                }
            }

            if(startTimeValue[0].toInt() in 10..24) {
                duration -= 3;
                startTimeValue[0] = (startTimeValue[0].toInt() + 3).toString()
                reservationPayment += 55
                Log.d(TAG, "startTimeValue update = " + startTimeValue[0].toInt());
                Log.d(TAG, "duration" + duration)
                Log.d(TAG, "Looped1")

                if(duration >= 12) {
                    for(i in 1..12) {
                        Log.d(TAG, "Looped2")
                        duration -= 1
                        startTimeValue[0] = (startTimeValue[0].toInt() + 1).toString()
                        reservationPayment += 10
                    }
                } else {
                    for(i in 1 .. duration) {
                        Log.d(TAG, "Looped2")
                        duration -= 1
                        startTimeValue[0] = (startTimeValue[0].toInt() + 1).toString()
                        reservationPayment += 10
                    }
                }
            }
//            if(startTimeValue[0] 4)
//                4 to 959am
//                        first 3 hours 55
//            succeeding 30
//
//            10 to 359am
//                    first 3 hours 55
//            succeeding 10
//
//            weekends and holidays 60pesos whole day

            Log.d(TAG, "startTimeValue" + startTimeValue)
            Log.d(TAG, "startTimeTrueValue" + startTimeTrueValue)
            Log.d(TAG, "endTimeValue" + endTimeValue)
            Log.d(TAG, "endTimeTrueValue" + endTimeTrueValue)
            Log.d(TAG, "reservationPayment" + reservationPayment)
            Log.d(TAG, "reserve location slot launcher =" + name + imageId + date + position + startTime + endTime + isOvernight)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize ViewBinding for the HomeActivity
        homeActivityBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(homeActivityBinding.root)

        // RecyclerView setup
        this.recyclerView = homeActivityBinding.locationsRecyclerView1
        this.locationAdapter = LocationAdapter(locationModelList, reserveLocationSlotLauncher)
        this.recyclerView.adapter = locationAdapter
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        this.snapHelper.attachToRecyclerView(recyclerView)

        homeActivityBinding.profileBtn.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
            finish()
        }

        homeActivityBinding.viewReservationsBtn.setOnClickListener {
            val intent = Intent(this, ReservationsActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}