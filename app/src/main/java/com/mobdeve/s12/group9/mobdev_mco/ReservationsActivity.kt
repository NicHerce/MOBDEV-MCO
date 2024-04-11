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
import com.mobdeve.s12.group9.mobdev_mco.Adapter.ReservationsAdapter
import com.mobdeve.s12.group9.mobdev_mco.Model.ReservationModel
import com.mobdeve.s12.group9.mobdev_mco.ValuesGenerator.ReservationGenerator
import com.mobdeve.s12.group9.mobdev_mco.databinding.ActivityViewReservationsBinding

class ReservationsActivity : AppCompatActivity() {
    companion object {
        const val TAG: String = "Reservations Activity"
    }

    // Generate the data for Reservations
    private val reservationModelList: ArrayList<ReservationModel> = ReservationGenerator.loadData()

    private lateinit var recyclerView: RecyclerView               // RecyclerView reference
    private lateinit var reservationsAdapter: ReservationsAdapter // Adapter reference
    private val snapHelper: SnapHelper = LinearSnapHelper()       // SnapHelper reference

    // Activity reference
    private lateinit var viewReservationsActivityBinding: ActivityViewReservationsBinding

    private val reservationDetailsLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
        Log.d(TAG, "reservation details launcher")

        if(result.resultCode == RESULT_OK) {
            val status = result.data?.getStringExtra(ReservationDetailsActivity.statusKey)!!
            val location = result.data?.getStringExtra(ReservationDetailsActivity.locationKey)!!
            val date = result.data?.getStringExtra(ReservationDetailsActivity.dateKey)!!
            val time = result.data?.getStringExtra(ReservationDetailsActivity.timeKey)!!
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize ViewBinding for the ViewReservationsActivity
        viewReservationsActivityBinding = ActivityViewReservationsBinding.inflate(layoutInflater)
        setContentView(viewReservationsActivityBinding.root)

        // RecyclerView setup
        this.recyclerView = viewReservationsActivityBinding.reservationsRecyclerView
        this.reservationsAdapter = ReservationsAdapter(reservationModelList, reservationDetailsLauncher)
        this.recyclerView.adapter = reservationsAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        this.snapHelper.attachToRecyclerView(recyclerView)

        viewReservationsActivityBinding.locationsBtn.setOnClickListener {
            val intent = Intent(this, LocationActivity::class.java)
            startActivity(intent)
            finish()
        }

        viewReservationsActivityBinding.profileBtn.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}