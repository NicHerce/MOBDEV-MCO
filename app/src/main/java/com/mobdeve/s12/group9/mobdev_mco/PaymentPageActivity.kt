package com.mobdeve.s12.group9.mobdev_mco

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.mobdeve.s12.group9.mobdev_mco.databinding.ActivityPaymentPageBinding
import com.mobdeve.s12.group9.mobdev_mco.databinding.ActivityReserveLocationBinding

class PaymentPageActivity : AppCompatActivity() {
    companion object {
        const val TAG: String = "Payment Page Activity"
    }

    private lateinit var paymentPageViewBinding: ActivityPaymentPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG, "onCreate finished execution")
        super.onCreate(savedInstanceState)
        this.paymentPageViewBinding = ActivityPaymentPageBinding.inflate(layoutInflater)
        setContentView(paymentPageViewBinding.root)

        paymentPageViewBinding.tvTotalPrice.setText("₱" + intent.getIntExtra(LocationActivity.reservationPaymentKey, 0).toString())
        Log.d(TAG, "reserve location id 2 =" + intent.getIntExtra(LocationActivity.reservationPaymentKey, 0))

        paymentPageViewBinding.btnConfirm.setOnClickListener {
            //Payment logic
            val intent = Intent(this, ViewReservationsActivity::class.java)
            startActivity(intent)
            finish()
        }

        paymentPageViewBinding.locationsBtn.setOnClickListener {
            val intent = Intent(this, LocationActivity::class.java)
            startActivity(intent)
            finish()
        }

        paymentPageViewBinding.viewReservationsBtn.setOnClickListener {
            val intent = Intent(this, ViewReservationsActivity::class.java)
            startActivity(intent)
            finish()
        }

        paymentPageViewBinding.profileBtn.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}