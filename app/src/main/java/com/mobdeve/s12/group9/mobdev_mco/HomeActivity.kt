package com.mobdeve.s12.group9.mobdev_mco

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SnapHelper
import com.mobdeve.s12.group9.mobdev_mco.databinding.ActivityHomeBinding
import com.mobdeve.s12.group9.mobdev_mco.databinding.ActivityProfileBinding

class HomeActivity : AppCompatActivity() {
    // Our data
    private val locationList: ArrayList<Location> = LocationGenerator.loadData()

    private lateinit var recyclerView: RecyclerView         // RecyclerView reference
    private lateinit var myAdapter: MyAdapter               // Adapter reference
    private val snapHelper: SnapHelper = LinearSnapHelper() // SnapHelper reference
    private lateinit var homeActivityBinding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize ViewBinding for the HomeActivity
        homeActivityBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(homeActivityBinding.root)

        // RecyclerView setup
        this.recyclerView = homeActivityBinding.locationsRecyclerView1
        this.myAdapter = MyAdapter(locationList)
        this.recyclerView.adapter = myAdapter
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        this.snapHelper.attachToRecyclerView(recyclerView)

        homeActivityBinding.profileBtn.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
            finish()
        }

        homeActivityBinding.viewReservationsBtn.setOnClickListener {
            val intent = Intent(this, ViewReservationsActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}