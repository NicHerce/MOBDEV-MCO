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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize ViewBinding for the HomeActivity
        val viewBinding: ActivityHomeBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        // RecyclerView setup
        this.recyclerView = viewBinding.locationsRecyclerView1
        this.myAdapter = MyAdapter(locationList)
        this.recyclerView.adapter = myAdapter
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        this.snapHelper.attachToRecyclerView(recyclerView)

        viewBinding.profileBtn.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }
    }
}