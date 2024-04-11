package com.mobdeve.s12.group9.mobdev_mco

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Color
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.zxing.BarcodeFormat
import com.mobdeve.s12.group9.mobdev_mco.databinding.ActivityReservationDetailsBinding
import com.google.zxing.WriterException
import com.google.zxing.common.BitMatrix
import com.google.zxing.qrcode.QRCodeWriter
class ReservationDetailsActivity : AppCompatActivity() {

    companion object {
        const val TAG         = "Reservation Details Activity"
        const val statusKey   = "STATUS_KEY"
        const val locationKey = "LOCATION_KEY"
        const val dateKey     = "DATE_KEY"
        const val timeKey     = "TIME_KEY"
    }

    lateinit var ivQRCode: ImageView
    lateinit var bitmap: Bitmap

    private lateinit var viewActivityReservationDetailsBinding: ActivityReservationDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Initialize ViewBinding for the ReservationDetailsActivity
        viewActivityReservationDetailsBinding = ActivityReservationDetailsBinding.inflate(layoutInflater)
        setContentView(viewActivityReservationDetailsBinding.root)

        // Generate a QR code with String data
        generateQRCode("nigger")

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        viewActivityReservationDetailsBinding.locationsBtn.setOnClickListener {
            val intent = Intent(this, LocationActivity::class.java)
            startActivity(intent)
            finish()
        }

        viewActivityReservationDetailsBinding.profileBtn.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun generateQRCode(data: String) {
        val qrCodeWriter = QRCodeWriter()
        try {
            val bitMatrix: BitMatrix = qrCodeWriter.encode(data, BarcodeFormat.QR_CODE, 512, 512)
            val width = bitMatrix.width
            val height = bitMatrix.height
            val bmp = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565)
            for (x in 0 until width) {
                for (y in 0 until height) {
                    bmp.setPixel(x, y, if (bitMatrix.get(x, y)) Color.BLACK else Color.WHITE)
                }
            }
            val imageViewQRCode: ImageView = findViewById(R.id.ivQRCode)
            imageViewQRCode.setImageBitmap(bmp)
        } catch (e: WriterException) {
            e.printStackTrace()
        }
    }
}