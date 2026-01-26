package com.example.movies.di

import com.example.movies.data.repository.MoviesRepository
import org.koin.dsl.module

val dataModule = module {
    factory { MoviesRepository(get()) }
}