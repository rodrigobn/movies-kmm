package com.example.movies.ui.movies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movies.data.repository.MoviesRepository
import com.example.movies.domain.model.MovieSection
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MoviesListViewModel(
    private val moviesRepository: MoviesRepository
) : ViewModel() {

    private val _moviesListState = MutableStateFlow<MoviesListState>(MoviesListState.Loading)
    val moviesListState = _moviesListState.asStateFlow()

    init {
        getMovieSections()
    }

    private fun getMovieSections() {
        viewModelScope.launch {
            try {
                val movieSections = moviesRepository.getMovieSections()
                _moviesListState.update {
                    MoviesListState.Success(movieSections)
                }
            } catch (e: Exception) {
                _moviesListState.update {
                    MoviesListState.Error(e.message ?: "An unexpected error occurred")
                }
            }
        }
    }

    sealed interface MoviesListState {
        object Loading : MoviesListState
        data class Success(val movieSections: List<MovieSection>) : MoviesListState
        data class Error(val message: String) : MoviesListState
    }
}