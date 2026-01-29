package com.example.movies.navigation

import kotlinx.serialization.Serializable

sealed interface AppRoutes {
    @Serializable
    data object MovieList : AppRoutes
    @Serializable
    data class MovieDetail(val id: Int) : AppRoutes
}