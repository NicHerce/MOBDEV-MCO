package com.mobdeve.s12.group9.mobdev_mco

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mobdeve.s12.group9.mobdev_mco.databinding.ActivityLoginBinding

class LoginActivity: AppCompatActivity() {
    private lateinit var loginActivityBinding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        loginActivityBinding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(loginActivityBinding.root)

        loginActivityBinding.btnLoginLogin.setOnClickListener() {
            val intent = Intent(this, LocationActivity::class.java)
            startActivity(intent)
        }

    }
}