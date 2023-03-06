package com.example.mymovies.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.mymovies.R
import com.example.mymovies.model.ItemMovie
import com.example.mymovies.sys.loadImage

class MoviesAdapter(
    private val onMovieItemClick: OnMovieItemClick,
        private val context: Context
    ): RecyclerView.Adapter<MoviesAdapter.HolderMovie>() {

    private val movieList = ArrayList<ItemMovie>()

    // limpiar la lista, agregar todos los item y notificar al adapter del cambio de dataset
    fun addMovies(movies: List<ItemMovie>){
        movieList.clear()
        movieList.addAll(movies)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderMovie {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return HolderMovie(inflater)
    }

    override fun getItemCount(): Int = movieList.size

    override fun onBindViewHolder(holder: HolderMovie, position: Int) {
        val movie: ItemMovie = movieList[position]
        holder.setMovie(movie)
    }

    // Se crea una clase anidada
    inner class HolderMovie(itemView: View) : RecyclerView.ViewHolder(itemView){

        private var poster : ImageView
        private var title: TextView
        private var overview : TextView
        private var rate: TextView
        private var movieCard : CardView

        init {
            poster = itemView.findViewById(R.id.cover)
            title = itemView.findViewById(R.id.title)
            overview = itemView.findViewById(R.id.description)
            rate = itemView.findViewById(R.id.average)
            movieCard = itemView.findViewById(R.id.movieCard)
        }

        fun setMovie(movie : ItemMovie){
            poster.loadImage(movie.movieCover, context)
            title.text = movie.movieTitle
            overview.text = movie.description
            rate.text = movie.voteAverage

            movieCard.setOnClickListener {
                onMovieItemClick.onMovieItemClicked(movie)
            }
        }

    }

}