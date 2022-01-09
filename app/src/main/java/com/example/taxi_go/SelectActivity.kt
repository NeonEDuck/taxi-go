package com.example.taxi_go

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.taxi_go.databinding.ActivitySelectBinding

class SelectActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val views = ActivitySelectBinding.inflate(layoutInflater)
        setContentView(views.root)

        views.txvAccount.text = Storage.account
        views.txvMemberName.text = "陳阿罵"

        views.profilePicture.setOnClickListener {
            intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
        }

            views.btnNormal.setOnClickListener {
            intent = Intent(this, MrtNormalActivity::class.java)
            startActivity(intent)
        }

        views.btnAccessibility.setOnClickListener {
            intent = Intent(this, MrtActivity::class.java)
            startActivity(intent)
        }
    }
}