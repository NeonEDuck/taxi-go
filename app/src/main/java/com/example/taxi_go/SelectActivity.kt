package com.example.taxi_go

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.taxi_go.databinding.ActivitySelectBinding

class SelectActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val views = ActivitySelectBinding.inflate(layoutInflater)
        setContentView(views.root)


    }
}