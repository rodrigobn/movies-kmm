package com.example.movies

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.movies.di.dataModule
import com.example.movies.di.networkModule
import com.example.movies.di.viewModelModule
import com.example.movies.navigation.AppRoutes
import com.example.movies.ui.moviedetail.MovieDetailRoute
import com.example.movies.ui.movies.MoviesListRoute
import com.example.movies.ui.theme.MoviesAppTheme
import org.koin.compose.KoinApplication

@Composable
@Preview
fun App() {
    KoinApplication(
        application = {
            modules(networkModule, dataModule, viewModelModule)
        }
    ) {
        MoviesAppTheme {
            val navController = rememberNavController()
            NavHost(
                navController, startDestination = AppRoutes.MovieList
            ) {
                composable<AppRoutes.MovieList> {
                    MoviesListRoute(
                        navigateToMovieDetail = { movieId ->
                            navController.navigate(AppRoutes.MovieDetail(movieId))
                        }
                    )
                }

                composable<AppRoutes.MovieDetail> {
                    MovieDetailRoute(
                        navigateBack = {
                            navController.popBackStack()
                        }
                    )
                }
            }
        }
    }
}