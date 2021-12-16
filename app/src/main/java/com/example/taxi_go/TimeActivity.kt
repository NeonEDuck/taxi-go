package com.example.taxi_go

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.DatePicker
import com.example.taxi_go.databinding.ActivityTimeBinding
import java.util.*

class TimeActivity : AppCompatActivity() {
    var year = 0
    var month = 0
    var day = 0
    var hour = 0
    var minute = 0
    var interval = 0
    private var _binding: ActivityTimeBinding? = null
    private val views get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityTimeBinding.inflate(layoutInflater)
        setContentView(views.root)

        val originId: Int       = intent.getIntExtra(ORIGIN_ID, R.string.station_taipei_station)
        val destinationId: Int  = intent.getIntExtra(DESTINATION_ID, R.string.station_taipei_station)
        interval                = intent.getIntExtra(INTERVAL_ID, 0)

        val c = Calendar.getInstance()
        year = c.get(Calendar.YEAR)
        month = c.get(Calendar.MONTH)
        day = c.get(Calendar.DAY_OF_MONTH)


        views.txvOrigin.text = resources.getString(originId)
        val txt = "$interval ${resources.getString(R.string.minute)}"
        views.txvInterval.text = txt
        views.txvDestination.text = resources.getString(destinationId)

        views.lahDatePicker.setOnClickListener {
            val datePicker = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { _, year, month, dayOfMonth ->
                this.year = year
                this.month = month
                this.day = dayOfMonth
                updateTime()
            }, year, month, day)

            datePicker.show()
        }

        views.lahTimePicker.setOnClickListener {
            val timePicker = TimePickerDialog(this, TimePickerDialog.OnTimeSetListener { _, hour, minute ->
                this.hour = hour
                this.minute = minute
                updateTime()
            }, hour, minute, true)

            timePicker.show()
        }

        views.lahDatePickerAfter.setOnClickListener {
            val timeAfter = hour * 60 + minute + interval
            val timePicker = TimePickerDialog(this, TimePickerDialog.OnTimeSetListener { _, hour, minute ->
                val timeBefore = hour * 60 + minute - interval
                this.hour   = timeBefore / 60
                this.minute = timeBefore % 60
                updateTime()
            }, (timeAfter / 60), (timeAfter % 60), true)

            timePicker.show()
        }
    }

    private fun updateTime() {
        views.txvYear.text      = year.toString()
        views.txvMonth.text     = month.toString().padStart(2, '0')
        views.txvDay.text       = day.toString().padStart(2, '0')
        views.txvHour.text      = hour.toString().padStart(2, '0')
        views.txvMinute.text    = minute.toString().padStart(2, '0')

        val timeAfter = hour * 60 + minute + interval
        views.txvHourAfter.text     = (timeAfter / 60).toString().padStart(2, '0')
        views.txvMinuteAfter.text   = (timeAfter % 60).toString().padStart(2, '0')
    }
}