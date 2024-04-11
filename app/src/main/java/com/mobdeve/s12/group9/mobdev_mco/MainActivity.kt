/*
*
* */

package com.mobdeve.s12.group9.mobdev_mco

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.autofill.UserData
import android.util.Log
import android.widget.Toast
import com.mobdeve.s12.group9.mobdev_mco.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    companion object {
        const val TAG: String = "Main Activity"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewBinding: ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        viewBinding.btnLoginLogin.setOnClickListener {

            //TODO: Login Logic
//            val email = viewBinding.edtLoginEmail.text.toString()
//            val password = viewBinding.edtLoginPassword.text.toString()
//
//            val res = UserDatabase.checkPassword(email, password)
//
//            if (res) {
//                val intent = Intent(this, LocationActivity::class.java)
//                startActivity(intent)
//            } else {
//
//            }

            val intent = Intent(this, LocationActivity::class.java)
            startActivity(intent)
        }

        viewBinding.txvLoginRegisterbutton.setOnClickListener{
            val intent = Intent( this, RegisterActivity::class.java)
            startActivity(intent)
        }

        Log.d(TAG, "onCreate finished execution")
    }
}