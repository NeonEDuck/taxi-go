package com.example.taxi_go

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.taxi_go.databinding.ActivityResultBinding
import com.example.taxi_go.databinding.ActivityResultNormalBinding

class ResultNormalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val views = ActivityResultNormalBinding.inflate(layoutInflater)
        setContentView(views.root)

        val destinationId: Int  = intent.getIntExtra(DESTINATION_ID, R.string.station_taipei_station)

        views.txvDestination.text = resources.getString(destinationId)

        views.btnCancel.setOnClickListener {
            finish()
        }

        views.btnConfirm.setOnClickListener {
            intent = Intent(this, SelectActivity::class.java)
            startActivity(intent)
        }

    }
}