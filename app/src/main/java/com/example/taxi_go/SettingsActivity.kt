package com.example.taxi_go

import android.content.Intent
import android.content.res.Resources
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Switch
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.marginTop
import com.example.taxi_go.databinding.ActivitySettingsBinding
import java.util.*

class SettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val views = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(views.root)

        views.btnBack.setOnClickListener {
            finish()
        }

        val settings = mapOf<Int, Boolean>(
            R.string.notification_mrt   to false,
            R.string.notification_taxi  to true,
            R.string.notification_taxi_before  to false,
            R.string.notification_on_taxi  to true,
        )

        for ( (strId, state) in settings ) {
            val setting = this.layoutInflater.inflate(R.layout.row_setting, null)
            setting.findViewById<TextView>(R.id.txvDescription).text = resources.getString(strId)
            setting.findViewById<Switch>(R.id.swhToggle).isChecked = state
            views.settingList.addView(setting)
        }

        for (record in Storage.recordList) {
            val originId        = record.originId
            val destinationId   = record.destinationId
            val date            = record.date
            val timeBefore      = record.timeBefore
            val timeAfter       = record.timeAfter

            val reservationInfo = this.layoutInflater.inflate(R.layout.reservation_info, views.reservationList, true)
            reservationInfo.findViewById<TextView>(R.id.txvOrigin).text      = "${resources.getString(originId)}\n$timeBefore"
            reservationInfo.findViewById<TextView>(R.id.txvDestination).text = "${resources.getString(destinationId)}\n$timeAfter"
            reservationInfo.findViewById<TextView>(R.id.txvDate).text        = date

            views.btnBack.setOnClickListener {
                intent = Intent(this, SelectActivity::class.java)
                startActivity(intent)
            }
        }
    }
}