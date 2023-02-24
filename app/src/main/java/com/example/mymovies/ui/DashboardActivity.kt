package com.example.mymovies.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.mymovies.R

class DashboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
    }

    override fun onStart() {
        super.onStart()

        val imgUser = findViewById<ImageView>(R.id.imgUser)

        // Al presionar la imagen de usuario, ir a la vista de dashboard
        imgUser.setOnClickListener {
            val intent = Intent(this@DashboardActivity, MainActivity::class.java)
            startActivity(intent)
            this.finish()
        }
    }
}