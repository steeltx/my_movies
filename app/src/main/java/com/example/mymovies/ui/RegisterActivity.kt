package com.example.mymovies.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.example.mymovies.R

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
    }

    override fun onStart() {
        super.onStart()
        val btnRegresar = findViewById<ImageView>(R.id.imgRegresar)
        val btnRegistro = findViewById<Button>(R.id.btnRegistro)

        // Al presionar el boton de regreso, ir a la vista de login
        btnRegresar.setOnClickListener {
            val intent = Intent(this@RegisterActivity, MainActivity::class.java)
            startActivity(intent)
            this.finish()
        }

        // Al presionar el boton de registro, ir a la vista de dashboard
        btnRegistro.setOnClickListener {
            val intent = Intent(this@RegisterActivity, DashboardActivity::class.java)
            startActivity(intent)
            this.finish()
        }
    }
}