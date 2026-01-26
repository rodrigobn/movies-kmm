package com.example.movies.di

import com.example.movies.data.network.KtorClient
import org.koin.dsl.module

val networkModule = module {
    single { KtorClient() }
}