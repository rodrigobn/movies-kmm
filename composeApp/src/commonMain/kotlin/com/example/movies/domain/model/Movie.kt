package com.example.movies.domain.model

import com.example.movies.data.network.IMAGE_SMALL_BASE_URL
import com.example.movies.data.network.model.MovieResponse

data class Movie(
    val id: String,
    val title: String,
    val posterUrl: String,
    val overview: String
)

fun MovieResponse.toModel(): Movie {
    return Movie(
        id = id.toString(),
        title = title,
        posterUrl = "$IMAGE_SMALL_BASE_URL${this.posterPath}",
        overview = overview
    )
}

// fake data for testing and previews
val sampleMovies = List(10) { index ->
    Movie(
        id = index.toString(),
        title = "Movie Title $index",
        posterUrl = "https://via.placeholder.com/150",
        overview = "This is a brief overview of Movie Title $index."
    )
}