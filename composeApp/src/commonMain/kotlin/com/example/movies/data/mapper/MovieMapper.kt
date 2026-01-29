package com.example.movies.data.mapper

import com.example.movies.data.network.IMAGE_BASE_URL
import com.example.movies.data.network.model.CastMemberResponse
import com.example.movies.data.network.model.MovieResponse
import com.example.movies.domain.model.ImageSize
import com.example.movies.domain.model.Movie
import com.example.movies.utils.formatRating
import kotlin.math.roundToInt

private const val ACTING = "Acting"

fun MovieResponse.toModel(
    castMembersResponse: List<CastMemberResponse>? = null,
    movieTrailerYoutubeKey: String? = null,
    imageSize: ImageSize = ImageSize.SMALL
): Movie {
    return Movie(
        id = id,
        title = title,
        overview = overview,
        posterUrl = "$IMAGE_BASE_URL/${imageSize.size}/${this.posterPath}",
        genres = this.genres?.map { it.toModel() },
        year = this.formatYear(),
        duration = this.formatDuration(),
        rating = this.voteAverage.formatRating(),
        castMembers = castMembersResponse
            ?.filter { it.department == ACTING }
            ?.take(20)
            ?.map { it.toModel() },
        movieTrailerYoutubeKey = movieTrailerYoutubeKey
    )
}

private fun MovieResponse.formatYear(): Int {
    return this.release.year
}

private fun MovieResponse.formatDuration(): String? {
    return this.runtime?.let { runtime ->
        val hours = runtime / 60
        val minutes = runtime % 60
        buildString {
            if (hours > 0) {
                append("${hours}h ")
            }
            if (minutes > 0) {
                append("${minutes}m")
            }
        }.trim()
    }
}