package com.example.mymovies.domain

import com.example.mymovies.datasource.api.RetrofitService
import javax.inject.Inject

class MoviesRepository {

    @Inject
    lateinit var retrofitService : RetrofitService

    init {

    }

    fun getMovies(){

    }

}