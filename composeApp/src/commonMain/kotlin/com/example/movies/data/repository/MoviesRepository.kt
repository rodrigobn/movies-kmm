package com.example.movies.data.repository

import com.example.movies.data.mapper.toModel
import com.example.movies.data.network.KtorClient
import com.example.movies.domain.model.ImageSize
import com.example.movies.domain.model.Movie
import com.example.movies.domain.model.MovieSection
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext

private const val YOU_TUBE = "YouTube"

class MoviesRepository(
    private val ktorClient: KtorClient = KtorClient(),
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) {
    suspend fun getMovieSections(): List<MovieSection> {
        return withContext(ioDispatcher) {
            val popularMoviesDeferred = async { ktorClient.getMovie("popular") }
            val topRatedMoviesDeferred = async { ktorClient.getMovie("top_rated") }
            val upcomingMoviesDeferred = async { ktorClient.getMovie("upcoming") }

            val popularMovies = popularMoviesDeferred.await()
            val topRatedMovies = topRatedMoviesDeferred.await()
            val upcomingMovies = upcomingMoviesDeferred.await()

            listOf(
                MovieSection(
                    sectionType = MovieSection.SectionType.POPULAR,
                    movies = popularMovies.results.map { it.toModel() }
                ),
                MovieSection(
                    sectionType = MovieSection.SectionType.TOP_RATED,
                    movies = topRatedMovies.results.map { it.toModel() }
                ),
                MovieSection(
                    sectionType = MovieSection.SectionType.UPCOMING,
                    movies = upcomingMovies.results.map { it.toModel() }
                )
            )
        }
    }

    suspend fun getMovieDetails(movieId: Int): Result<Movie> {
        return withContext(ioDispatcher) {
            runCatching {
                val movieDetailsDeferred = async { ktorClient.getMovieDetail(movieId) }
                val creditsDeferred = async { ktorClient.getCredits(movieId) }
                val trailerDeferred = async { ktorClient.getVideos(movieId) }

                val movieDetailsResponse = movieDetailsDeferred.await()
                val creditsResponse = creditsDeferred.await()
                val trailerResponse = trailerDeferred.await()

                val movieTrailerYoutubeKey = trailerResponse.results.firstOrNull { video ->
                    video.site == YOU_TUBE
                }?.key

                movieDetailsResponse.toModel(
                    castMembersResponse = creditsResponse.cast,
                    movieTrailerYoutubeKey = movieTrailerYoutubeKey,
                    imageSize = ImageSize.X_LARGE)
            }
        }
    }
}