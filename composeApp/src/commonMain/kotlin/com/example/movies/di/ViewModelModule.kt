package com.example.movies.di

import com.example.movies.ui.moviedetail.MovieDetailViewModel
import com.example.movies.ui.movies.MoviesListViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MoviesListViewModel(get()) }
    viewModel { MovieDetailViewModel(get(), get()) }
}