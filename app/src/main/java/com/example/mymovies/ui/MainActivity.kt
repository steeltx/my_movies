package com.example.mymovies.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.mymovies.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()

        // Referencia hacia los elementos de la vista
        val btnRegistro = findViewById<Button>(R.id.btnRegistrarse)
        val btnLogin = findViewById<Button>(R.id.btnLogin)

        // Al presionar el boton de registro, ir a la vista de registrar
        btnRegistro.setOnClickListener {
            val intent = Intent(this@MainActivity, RegisterActivity::class.java)
            startActivity(intent)
            this.finish()
        }

        // Al presionar el boton de login, ir a la vista de dashboard
        btnLogin.setOnClickListener {
            val intent = Intent(this@MainActivity, DashboardActivity::class.java)
            startActivity(intent)
            this.finish()
        }

    }
}