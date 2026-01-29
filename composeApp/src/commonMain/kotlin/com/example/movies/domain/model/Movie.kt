package com.example.movies.domain.model

data class Movie(
    val id: Int,
    val title: String,
    val overview: String,
    val posterUrl: String,
    val genres: List<Genre>?,
    val year: Int,
    val duration: String?,
    val rating: String,
    val castMembers: List<CastMember>?,
    val movieTrailerYoutubeKey: String?
)

// fake data for testing and previews
val sampleMovies = List(10) { index ->
    Movie(
        id = index,
        title = "Movie Title $index",
        posterUrl = "https://via.placeholder.com/150",
        overview = "This is a brief overview of Movie Title $index.",
        genres = fakeGenres,
        year = 2023,
        duration = "2h 36m",
        rating = "8.5",
        castMembers = fakeCastMembers,
        movieTrailerYoutubeKey = "dQw4w9WgXcQ"
    )
}