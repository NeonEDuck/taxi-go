package com.example.taxi_go

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.taxi_go.databinding.ActivityOrderBinding

class OrderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val views = ActivityOrderBinding.inflate(layoutInflater)
        setContentView(views.root)

        val originId: Int       = intent.getIntExtra(ORIGIN_ID, R.string.station_taipei_station)
        val destinationId: Int  = intent.getIntExtra(DESTINATION_ID, R.string.station_taipei_station)

        views.txvOrigin.text = resources.getString(originId)
        views.txvDestination.text = resources.getString(destinationId)
    }
}