package com.example.mymovies.ui.movies

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mymovies.R
import com.example.mymovies.domain.MoviesViewModel
import com.example.mymovies.model.ItemMovie
import com.example.mymovies.ui.adapters.MoviesAdapter
import com.example.mymovies.ui.adapters.OnMovieItemClick

class MoviesFragment : Fragment(), OnMovieItemClick {

    private lateinit var viewModel: MoviesViewModel
    private lateinit var adapterMovies: MoviesAdapter
    private lateinit var rvMovies: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        adapterMovies = MoviesAdapter(this, requireContext())
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movies, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Inicializar el viewmodel
        viewModel = ViewModelProvider(this)[MoviesViewModel::class.java]

        rvMovies = view.findViewById(R.id.rvMovies)

        rvMovies.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = adapterMovies
            setHasFixedSize(true)
        }

        viewModel.movieList.observe(viewLifecycleOwner){ movies ->
            // agregar la logica cuando se recibe informacion
            adapterMovies.addMovies(movies)
        }
    }

    override fun onStart() {
        super.onStart()
        // Al iniciar, llamar al metodo para obtener todas las peliculas
        viewModel.getMovies()
    }

    override fun onMovieItemClicked(movie: ItemMovie) {
        Toast.makeText(requireContext(), movie.movieTitle, Toast.LENGTH_SHORT).show()
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            MoviesFragment().apply {}
    }
}