package com.mobdeve.s12.group9.mobdev_mco

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
    private var location = "";
    private var date = "";
    private var time = ""

    //Go to location adapter, pass result back
    private val reserveLocationSlotLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
        if (result.resultCode == RESULT_OK) {
            val name: String = result.data?.getStringExtra(ReserveLocationActivity.nameKey)!!
            val imageId: Int = result.data?.getIntExtra(ReserveLocationActivity.imageIdKey, 0)!!
            val position: Int = result.data?.getIntExtra(ReserveLocationActivity.positionKey, 0)!!
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