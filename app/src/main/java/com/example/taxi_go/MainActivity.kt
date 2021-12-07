package com.example.taxi_go

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.taxi_go.databinding.ActivityMainBinding

const val EXTRA_EMAIL = "email"
const val EXTRA_PASSWORD = "password"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val views = ActivityMainBinding.inflate(layoutInflater)
            /*
             * To enable data binding feature, add below code
             * in build.gradle:
             * buildFeatures {
             *     viewBinding true
             * }
             */
        setContentView(views.root)
            // Change R.layout.activity_main to views.root or
            // the change on views.<id> won't register.

        views.btnRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        views.btnLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}