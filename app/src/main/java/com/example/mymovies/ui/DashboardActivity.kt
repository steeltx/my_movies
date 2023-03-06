package com.example.mymovies.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.example.mymovies.R
import com.example.mymovies.ui.discover.DiscoverMoviesFragment
import com.example.mymovies.ui.movies.MoviesFragment
import com.example.mymovies.ui.search.SearchMoviesFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView

class DashboardActivity : AppCompatActivity(), NavigationBarView.OnItemSelectedListener {

    // Widgets
    private lateinit var imgUser: ImageView
    private lateinit var container: FrameLayout
    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        // Se asigna las variables a la vista
        imgUser = findViewById(R.id.imgUser)
        container = findViewById(R.id.container)
        bottomNavigationView = findViewById(R.id.bottomNavigationView)

        bottomNavigationView.setOnItemSelectedListener(this)
        bottomNavigationView.selectedItemId = R.id.navMovies
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

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        // Cuando se de clic en cada elemento, cambiar el fragment seleccionado
        when(item.itemId){
            R.id.navMovies -> {
                changeFragment(MoviesFragment.newInstance())
            }
            R.id.navSearch -> {
                changeFragment(SearchMoviesFragment())
            }
            R.id.navDiscover -> {
                changeFragment(DiscoverMoviesFragment())
            }
        }
        return true
    }

    /**
     * Función que hace el cambio de fragment para que sea mostrado en la vista
     */
    private fun changeFragment(fragment: Fragment){

        /* El codigo de este bloque es lo mismo que el bloque siguiente
        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.commit()
        */

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.container, fragment)
            commit()
        }
    }

}