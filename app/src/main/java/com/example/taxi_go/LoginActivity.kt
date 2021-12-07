package com.example.taxi_go

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import com.example.taxi_go.databinding.ActivityLoginBinding
import com.example.taxi_go.databinding.ActivityRegisterBinding

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val views = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(views.root)

        val edtList = mapOf<EditText, TextView>(
            views.edtEmail      to views.hitEmail,
            views.edtPassword   to views.hitPassword,
        )

        views.btnLogin.setOnClickListener {
            var hasError = false

            for ((edt, hit) in edtList) {
                hit.text = ""
                if (edt.text.isBlank()) {
                    hasError = true
                    hit.text = "This field is empty.\n"
                }
            }

            if (!hasError) {
                val intent = Intent(this, SelectActivity::class.java)
                startActivity(intent)
            }
        }

        views.btnCancel.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}