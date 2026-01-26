package com.example.movies.navigation

import kotlinx.serialization.Serializable

sealed interface AppRoutes {
    @Serializable
    data object MovieList : AppRoutes
    @Serializable
    data class MovieDetails(val movieId: String) : AppRoutes
}