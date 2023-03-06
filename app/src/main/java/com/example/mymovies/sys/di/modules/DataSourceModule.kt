package com.example.mymovies.sys.di.modules

import com.example.mymovies.datasource.api.RetrofitService
import com.example.mymovies.sys.Constants
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class DataSourceModule {

    @Provides
    fun providesGson(): Gson {
        return GsonBuilder().create()
    }

    @Provides
    fun providesRetrofitInstance(gson: Gson) : RetrofitService{
        val retrofit = Retrofit.Builder()
            .baseUrl(Constants.theMovieDbBaseURL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
        return retrofit.create(RetrofitService::class.java)
    }

}