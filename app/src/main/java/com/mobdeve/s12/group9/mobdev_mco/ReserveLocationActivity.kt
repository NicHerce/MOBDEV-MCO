package com.mobdeve.s12.group9.mobdev_mco

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.mobdeve.s12.group9.mobdev_mco.databinding.ActivityReserveLocationBinding

class ReserveLocationActivity : AppCompatActivity() {
    companion object {
        const val TAG : String = "Reserve Location Activity"
        const val nameKey : String = "NAME_KEY"
        const val imageIdKey : String = "IMAGE_ID_KEY"
        const val positionKey: String = "POSITION_KEY"
    }

    private lateinit var nameString: String
    private lateinit var bodyString: String

    private lateinit var reserveLocationBinding: ActivityReserveLocationBinding   // Holds the views of the ActivityViewNoteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.reserveLocationBinding = ActivityReserveLocationBinding.inflate(layoutInflater)
        setContentView(reserveLocationBinding.root)

        Log.d(TAG, intent.getStringExtra(ReserveLocationActivity.nameKey).toString())
        reserveLocationBinding.tvLocationName.setText(intent.getStringExtra(ReserveLocationActivity.nameKey))
        Log.d(TAG, "reserve location id 2 =" + intent.getIntExtra(ReserveLocationActivity.imageIdKey, 0))
//        2131230962
        reserveLocationBinding.locationImageTv.setImageResource(intent.getIntExtra(ReserveLocationActivity.imageIdKey, 0))
        val position = intent.getIntExtra(ReserveLocationActivity.positionKey, 0)

        reserveLocationBinding.reserveBtn.setOnClickListener(View.OnClickListener{
            val intent: Intent = Intent()
            intent.putExtra(ReserveLocationActivity.nameKey, reserveLocationBinding.tvLocationName.text.toString())
            intent.putExtra(ReserveLocationActivity.nameKey, reserveLocationBinding.tvLocationName.id)
            intent.putExtra(ReserveLocationActivity.nameKey, position)

            setResult(Activity.RESULT_OK, intent)
            finish()
        })
//        reserveLocationBinding.
//
//        reserveLocationBinding.saveChangesBtn.setOnClickListener(View.OnClickListener {
//            val intent: Intent = Intent()
//            intent.putExtra(ReserveLocationActivity.nameKey, reserveLocationBinding.titleEtv.text.toString())
//            intent.putExtra(ReserveLocationActivity.imageIdKey, reserveLocationBinding.bodyEtv.text.toString())
//            intent.putExtra(ReserveLocationActivity.positionKey, position)
//
//            setResult(Activity.RESULT_OK, intent)
//            finish()
//        })
        }
    }