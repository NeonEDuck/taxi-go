package com.example.taxi_go

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import com.example.taxi_go.databinding.ActivityMrtBinding
import com.example.taxi_go.databinding.ActivityMrtNormalBinding

class MrtNormalActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val views = ActivityMrtNormalBinding.inflate(layoutInflater)
        setContentView(views.root)

        val btnList = mapOf<Button, Int>(
            views.btnTaipeiStation  to R.string.station_taipei_station,
            views.btnXinsheng       to R.string.station_xinsheng,
        )
        var curDestination: Int? = null

        changeStyleOf(views.btnConfirm, false)

        views.btnBack.setOnClickListener {
            finish()
        }

        for ((btn, stationId) in btnList) {
            btn.setOnClickListener {
                curDestination = stationId
                views.txvDestination.text = resources.getString(stationId)

                if (curDestination != null) {
                    changeStyleOf(views.btnConfirm, true)
                }
            }
        }

        views.btnConfirm.setOnClickListener {
            if (curDestination != null) {
                val intent = Intent(this, ResultNormalActivity::class.java).apply {
                    putExtra(DESTINATION_ID, curDestination)
                }
                startActivity(intent)
            }
        }
    }

    private fun changeStyleOf(btn: Button, active: Boolean) {
        if (active) {
            btn.backgroundTintList = resources.getColorStateList(R.color.yellow_200, this.theme)
        }
        else {
            btn.backgroundTintList = resources.getColorStateList(R.color.gray, this.theme)
        }
    }
}