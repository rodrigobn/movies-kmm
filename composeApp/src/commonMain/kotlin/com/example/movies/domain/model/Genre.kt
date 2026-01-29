package com.example.movies.domain.model

data class Genre(
    val id: Int,
    val name: String
)


// fake data for preview and testing
val fakeGenres = listOf(
    Genre(1, "Action"),
    Genre(2, "Comedy"),
    Genre(3, "Drama")
)