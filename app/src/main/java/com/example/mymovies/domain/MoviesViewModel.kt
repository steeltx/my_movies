package com.example.mymovies.domain

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mymovies.model.ItemMovie

class MoviesViewModel: ViewModel() {

    // Se ejecuta cuando se termina la app
    override fun onCleared() {
        super.onCleared()
    }

    val movieList by lazy { MutableLiveData<List<ItemMovie>>() }

    /**
     * Obtener el listado de peliculas
     */
    fun getMovies(){
        // Enviar un valor a live data
        movieList.postValue(listOf<ItemMovie>(
            ItemMovie("The Avengers","Marvel",""),
            ItemMovie("Spiderman","Marvel",""),
            ItemMovie("Thor","Marvel","")
        ))
    }

}
