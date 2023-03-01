package com.example.mymovies.sys.di.components

import com.example.mymovies.domain.MoviesRepository
import com.example.mymovies.sys.di.modules.DataSourceModule
import dagger.Component

@Component(modules = [DataSourceModule::class])
interface DataSourceComponent {
    fun inject(moviesRepository: MoviesRepository)
}