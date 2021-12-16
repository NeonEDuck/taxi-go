package com.example.taxi_go

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import com.example.taxi_go.databinding.ActivityMrtBinding

const val ORIGIN_ID = "originId"
const val DESTINATION_ID = "distinationId"
const val INTERVAL_ID = "intervalId"

class MrtActivity : AppCompatActivity() {
    enum class Options {
        Origin,
        Destination,
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val views = ActivityMrtBinding.inflate(layoutInflater)
        setContentView(views.root)

        val btnList = mapOf<Button, Int>(
            views.btnTaipeiStation  to R.string.station_taipei_station,
            views.btnXinsheng       to R.string.station_xinsheng,
        )
        var curOrigin: Int? = null
        var curDestination: Int? = null
        var curOption = Options.Origin
        var interval: Int = 0

        changeStyleOf(views.btnConfirm, false)
        changeStyleOf(views.lahOrigin, true)

        views.lahOrigin.setOnClickListener {
            curOption = Options.Origin
            changeStyleOf(views.lahOrigin, true)
            changeStyleOf(views.lahDestination, false)
        }

        views.lahDestination.setOnClickListener {
            curOption = Options.Destination
            changeStyleOf(views.lahOrigin, false)
            changeStyleOf(views.lahDestination, true)
        }

        for ((btn, stationId) in btnList) {
            btn.setOnClickListener {
                if (curOption == Options.Origin) {
                    curOrigin = stationId
                    views.txvOrigin.text = resources.getString(stationId)
                }
                else {
                    curDestination = stationId
                    views.txvDestination.text = resources.getString(stationId)
                }

                if (curOrigin != null && curDestination != null) {
                    interval = calculateTimeBetween(curOrigin!!, curDestination!!)
                    val text = "$interval ${resources.getString(R.string.minute)}"
                    views.txvTime.text = text
                    changeStyleOf(views.btnConfirm, true)
                }
            }
        }

        views.btnConfirm.setOnClickListener {
            if (curOrigin != null && curDestination != null) {
                val intent = Intent(this, TimeActivity::class.java).apply {
                    putExtra(ORIGIN_ID, curOrigin)
                    putExtra(DESTINATION_ID, curDestination)
                    putExtra(INTERVAL_ID, interval)
                }
                startActivity(intent)
            }
        }
    }

    private fun changeStyleOf(layout: LinearLayout, active: Boolean) {
        if (active) {
            layout.backgroundTintList = resources.getColorStateList(R.color.gray, this.theme)
            layout.elevation = 20f
        }
        else {
            layout.backgroundTintList = resources.getColorStateList(R.color.white, this.theme)
            layout.elevation = 0f
        }
    }

    private fun changeStyleOf(btn: Button, active: Boolean) {
        if (active) {
            btn.backgroundTintList = resources.getColorStateList(R.color.yellow_700, this.theme)
        }
        else {
            btn.backgroundTintList = resources.getColorStateList(R.color.gray, this.theme)
        }
    }

    private fun calculateTimeBetween(stationA: Int, stationB: Int): Int {
        // Call api

        return if (stationA != stationB) {
            8
        } else{
            0
        }

    }
}