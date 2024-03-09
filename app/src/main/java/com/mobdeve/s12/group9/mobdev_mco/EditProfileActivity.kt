package com.mobdeve.s12.group9.mobdev_mco

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mobdeve.s12.group9.mobdev_mco.databinding.ActivityEditProfileBinding

class EditProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)

        val viewBinding: ActivityEditProfileBinding = ActivityEditProfileBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

    }
}