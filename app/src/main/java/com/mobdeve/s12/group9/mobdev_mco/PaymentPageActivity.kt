package com.mobdeve.s12.group9.mobdev_mco

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.mobdeve.s12.group9.mobdev_mco.databinding.ActivityPaymentPageBinding

class PaymentPageActivity : AppCompatActivity() {
    companion object {
        const val TAG: String = "Main Activity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val paymentViewBinding: ActivityPaymentPageBinding = ActivityPaymentPageBinding.inflate(layoutInflater)
        setContentView(paymentViewBinding.root)

        Log.d(TAG, "onCreate finished execution")
    }
}