package com.mobdeve.s12.group9.mobdev_mco

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mobdeve.s12.group9.mobdev_mco.databinding.ActivityViewReservationsBinding

class ViewReservationsActivity : AppCompatActivity() {
    private lateinit var viewReservationsActivityBinding: ActivityViewReservationsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewReservationsActivityBinding = ActivityViewReservationsBinding.inflate(layoutInflater)
        setContentView(viewReservationsActivityBinding.root)

        viewReservationsActivityBinding.locationsBtn.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
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