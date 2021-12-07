package com.example.taxi_go

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.EditText
import android.widget.TextView
import com.example.taxi_go.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val views = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(views.root)

        val edtList = mapOf<EditText, TextView>(
            views.edtFirstName  to views.hitFirstName,
            views.edtLastName   to views.hitLastName,
            views.edtEmail      to views.hitEmail,
            views.edtPassword   to views.hitPassword,
            views.edtPassword2  to views.hitPassword2,
        )

        views.btnRegister.setOnClickListener {
            var hasError = false


            for ((_, hit) in edtList) {
                hit.text = ""
            }

            if (!views.edtPassword.text.toString().equals(views.edtPassword2.text.toString()) ) {
                hasError = true
                views.hitPassword2.append("The password doesn't match.\n")
            }

            for ((edt, hit) in edtList) {
                if (edt.text.isBlank()) {
                    hasError = true
                    hit.text = "This field is empty.\n"
                }

                if (hit.text.isNotEmpty()) {
                    hit.text = hit.text.subSequence(0 until hit.text.length-1)
                }
            }

            if (!hasError) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }

        views.btnCancel.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}