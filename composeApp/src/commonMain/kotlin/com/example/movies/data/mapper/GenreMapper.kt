package com.example.movies.data.mapper

import com.example.movies.data.network.model.GenreResponse
import com.example.movies.domain.model.Genre

fun GenreResponse.toModel() = Genre(
    id = this.id,
    name = this.name
)