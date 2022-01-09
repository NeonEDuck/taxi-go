package com.example.taxi_go

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.taxi_go.databinding.ActivityResultBinding
import com.example.taxi_go.databinding.ActivitySettingsBinding

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val views = ActivityResultBinding.inflate(layoutInflater)
        setContentView(views.root)

        val originId: Int       = intent.getIntExtra(ORIGIN_ID, R.string.station_taipei_station)
        val destinationId: Int  = intent.getIntExtra(DESTINATION_ID, R.string.station_taipei_station)
        val date: String?       = intent.getStringExtra(DATE_ID)
        val timeBefore: String? = intent.getStringExtra(TIME_BEFORE_ID)
        val timeAfter: String?  = intent.getStringExtra(TIME_AFTER_ID)


        views.txvOrigin.text      = "${resources.getString(originId)}\n$timeBefore"
        views.txvDestination.text = "${resources.getString(destinationId)}\n$timeAfter"
        views.txvDate.text        = date

        views.btnCancel.setOnClickListener {
            finish()
        }

        views.btnConfirm.setOnClickListener {
            Storage.recordList += Record(originId, destinationId, date, timeBefore, timeAfter)


            val intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
        }

    }
}