package com.mobdeve.s12.group9.mobdev_mco

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mobdeve.s12.group9.mobdev_mco.databinding.ActivityHomeBinding
import com.mobdeve.s12.group9.mobdev_mco.databinding.ActivityProfileBinding

class HomeActivity : AppCompatActivity() {
    // Our data
    private val locationList: ArrayList<Location> = LocationGenerator.loadData()

    // RecyclerView reference
    private lateinit var recyclerView: RecyclerView
    private lateinit var myAdapter: MyAdapter
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

        viewBinding.profileBtn.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }
    }
}