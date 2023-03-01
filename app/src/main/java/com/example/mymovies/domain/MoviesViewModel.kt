package com.example.mymovies.domain

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mymovies.model.ItemMovie

class MoviesViewModel: ViewModel() {

    lateinit var repository: MoviesRepository

    // LiveData hace un puente entre la UI y el viewModel
    val movieList by lazy { MutableLiveData<List<ItemMovie>>() }

    /**
     * Obtener el listado de peliculas
     */
    fun getMovies(){
        val movies = repository.getMovies()
    }

}
