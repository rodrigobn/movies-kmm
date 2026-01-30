package com.example.movies.previews

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.movies.domain.model.MovieSection
import com.example.movies.domain.model.sampleMovies
import com.example.movies.ui.components.CastMemberItem
import com.example.movies.ui.components.MovieGenreChip
import com.example.movies.ui.components.MovieInfoItem
import com.example.movies.ui.components.MoviePoster
import com.example.movies.ui.moviedetail.MovieDetailScreen
import com.example.movies.ui.moviedetail.MovieDetailViewModel
import com.example.movies.ui.movies.MoviesListScreen
import com.example.movies.ui.movies.MoviesListViewModel
import com.example.movies.ui.theme.MoviesAppTheme
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Solid
import compose.icons.fontawesomeicons.solid.Star

@Preview(showBackground = true)
@Composable
private fun MoviePosterPreview() {
    MoviePoster(
        sampleMovies.first(),
        onMoviePosterClick = {}
    )
}

@Preview(showBackground = true)
@Composable
fun MoviesListSuccessScreenPreview() {
    MoviesAppTheme {
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
            ),
            onMovieClick = { }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MoviesListErrorScreenPreview() {
    MoviesAppTheme {
        MoviesListScreen(
            moviesListState = MoviesListViewModel.MoviesListState.Error(message = "An error occurred while fetching movies."),
            onMovieClick = { }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MoviesListLoadingScreenPreview() {
    MoviesAppTheme {
        MoviesListScreen(
            moviesListState = MoviesListViewModel.MoviesListState.Loading,
            onMovieClick = { }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MoviesDetailScreenPreview() {
    MoviesAppTheme {
        MovieDetailScreen(
            movieDetailState = MovieDetailViewModel.MovieDetailState.Success(
                movie = sampleMovies.first()
            ),
            onNavigationIconClick = { }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MoviesInfoItemPreview() {
    MoviesAppTheme {
        MovieInfoItem(
            icon = FontAwesomeIcons.Solid.Star,
            text = "8.5"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MoviesGenreChipPreview() {
    MoviesAppTheme {
        MovieGenreChip(
            genre = "Action"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CastMemberItemPreview() {
    MoviesAppTheme {
        CastMemberItem(
            profilePictureUrl = "https://via.placeholder.com/150",
            name = "John Doe",
            character = "Hero"
        )
    }
}