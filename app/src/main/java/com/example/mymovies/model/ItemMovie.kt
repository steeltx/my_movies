package com.example.mymovies.model

/**
 * @param movieTitle Titulo de la pelicula
 * @param description Caratura de la pelicula
 * @param movieCover Descripcion de la pelicula
 */
data class ItemMovie(
    val movieId: Int,
    val movieTitle: String,
    val description: String,
    val movieCover : String,
    val popularity: Double,
    val releaseDate: String
)
