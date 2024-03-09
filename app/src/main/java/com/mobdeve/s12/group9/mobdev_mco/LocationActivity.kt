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
import com.mobdeve.s12.group9.mobdev_mco.databinding.ActivityHomeBinding

class LocationActivity : AppCompatActivity() {
    companion object {
        const val TAG: String = "Main Activity"
    }

    // Generate the data for Locations
    private val locationModelList: ArrayList<LocationModel> = LocationGenerator.loadData()

    private lateinit var recyclerView: RecyclerView               // RecyclerView reference
    private lateinit var locationAdapter: LocationAdapter                     // Adapter reference
    private val snapHelper: SnapHelper = LinearSnapHelper()       // SnapHelper reference

    // HomeActivityBinding reference
    private lateinit var homeActivityBinding: ActivityHomeBinding

    private val reserveLocationSlotLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
        if (result.resultCode == RESULT_OK) {
            val name: String = result.data?.getStringExtra(ReserveLocationActivity.nameKey)!!
            val imageId: Int = result.data?.getIntExtra(ReserveLocationActivity.imageIdKey, 0)!!
            val position: Int = result.data?.getIntExtra(ReserveLocationActivity.positionKey, 0)!!

//            Log.d(TAG, "" + name)
//            Log.d(TAG, "" + imageId)
//            Log.d(TAG, "" + position)
//            val locationModel = LocationModel(name, imageId)
//            Log.d(TAG, "" + locationModel)
//            this.locationModelList.removeAt(position)
//            this.locationModelList.add(position, locationModel)
//            this.myAdapter.notifyItemRemoved(position)
//            this.myAdapter.notifyDataSetChanged()
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