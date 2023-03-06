package com.example.mymovies.domain

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mymovies.model.ItemMovie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MoviesViewModel: ViewModel() {

    lateinit var repository: MoviesRepository

    init {
        repository = MoviesRepository()
    }

    // LiveData hace un puente entre la UI y el viewModel
    val movieList by lazy { MutableLiveData<List<ItemMovie>>() }
    val errorMovies by lazy { MutableLiveData<Unit>() }

    /**
     * Obtener el listado de peliculas
     */
    fun getMovies(){
        viewModelScope.launch {
            // Se encuentra en background
            val moviesResult = repository.getMovies()

            moviesResult.exception?.let {
                // Si entra aqui, existe un error
                errorMovies.value = Unit
            }

            moviesResult.entity?.let{movies ->
                // Si entra, se obtuvieron las peliculas
                movieList.value = movies
            }
        }
    }

}
