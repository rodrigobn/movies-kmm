package com.example.movies.previews

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.movies.domain.model.MovieSection
import com.example.movies.domain.model.sampleMovies
import com.example.movies.ui.components.MoviePoster
import com.example.movies.ui.movies.MoviesListScreen
import com.example.movies.ui.movies.MoviesListViewModel

@Preview(showBackground = true)
@Composable
private fun MoviePosterPreview() {
    MoviePoster(
        sampleMovies.first(),
    )
}

@Preview(showBackground = true)
@Composable
fun MoviesListSuccessScreenPreview() {
    MoviesListScreen(
        moviesListState = MoviesListViewModel.MoviesListState.Success(
            movieSections = listOf(
                MovieSection(
                    sectionType = MovieSection.SectionType.POPULAR,
                    movies = sampleMovies
                ),
                MovieSection(
                    sectionType = MovieSection.SectionType.TOP_RATED,
                    movies = sampleMovies
                ),
                MovieSection(
                    sectionType = MovieSection.SectionType.UPCOMING,
                    movies = sampleMovies
                )
            )
        )
    )
}

@Preview(showBackground = true)
@Composable
fun MoviesListErrorScreenPreview() {
    MoviesListScreen(
        moviesListState = MoviesListViewModel.MoviesListState.Error(message = "An error occurred while fetching movies.")
    )
}


@Preview(showBackground = true)
@Composable
fun MoviesListLoadingScreenPreview() {
    MoviesListScreen(
        moviesListState = MoviesListViewModel.MoviesListState.Loading
    )
}