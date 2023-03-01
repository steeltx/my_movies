package com.example.mymovies.datasource.api

import com.example.mymovies.datasource.api.model.MovieDto
import com.example.mymovies.datasource.api.model.MoviesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Interface que usa el patron facade para llamar a endpoint de API
 */
interface RetrofitService {

    // con suspend se ejecuta la funcion en segundo plano

    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key") apiKey: String,
        @Query("language") language: String,
        @Query("page") page: Int
    ): Response<MoviesResponse<MovieDto>>

    @GET("movie/top_rated")
    suspend fun getTopRatedMovies(
        @Query("api_key") apiKey: String,
        @Query("language") language: String,
        @Query("page") page: Int
    ): Response<MoviesResponse<MovieDto>>

    @GET("search/movie")
    suspend fun getMoviesBySearch(
        @Query("api_key") apiKey: String,
        @Query("language") language: String,
        @Query("query") query: String,
        @Query("page") page: Int,
        @Query("include_adult") includeAdult: Boolean
    ): Response<MoviesResponse<MovieDto>>
}