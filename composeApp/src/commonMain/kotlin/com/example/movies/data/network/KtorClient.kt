package com.example.movies.data.network

import com.example.movies.data.network.model.CreditsListResponse
import com.example.movies.data.network.model.MovieResponse
import com.example.movies.data.network.model.MoviesListResponse
import com.example.movies.data.network.model.VideosListResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.auth.Auth
import io.ktor.client.plugins.auth.providers.BearerTokens
import io.ktor.client.plugins.auth.providers.bearer
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.logging.SIMPLE
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

private const val BASE_URL = "https://api.themoviedb.org"
const val IMAGE_BASE_URL = "https://image.tmdb.org/t/p"

class KtorClient {
    private val client = HttpClient {
        install(ContentNegotiation) {
            json(
                Json {
                    prettyPrint = true
                    isLenient = true
                    ignoreUnknownKeys = true
                }
            )
        }

        install(Auth) {
            bearer {
                loadTokens {
                    BearerTokens(
                        accessToken = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIzZTMyNzIwYWI2ZDcyZWEzYmM3ZjhmMmJjMGIzMzgxYiIsIm5iZiI6MTc2OTE5OTIyMy4wMDE5OTk5LCJzdWIiOiI2OTczZDY3NjlhYzdiZTY0YjBlM2Q5ZDIiLCJzY29wZXMiOlsiYXBpX3JlYWQiXSwidmVyc2lvbiI6MX0.dF2ux8LB69o5qGaLjyjEyKZhy65Yo6ddZ5wJGZcqpc4",
                        refreshToken = ""
                    )
                }
            }
        }

        install(Logging) {
            logger = Logger.SIMPLE
            level = LogLevel.ALL
            sanitizeHeader { header -> header.equals("Authorization", ignoreCase = true) }
        }
    }

    suspend fun getMovie(category: String): MoviesListResponse {
        return client.get("$BASE_URL/3/movie/$category") {
            addLanguageParameter()
            parameter("page", "1")
        }.body()
    }

    suspend fun getMovieDetail(movieId: Int): MovieResponse {
        return client.get("$BASE_URL/3/movie/$movieId") {
            addLanguageParameter()
        }.body()
    }

    suspend fun getCredits(movieId: Int): CreditsListResponse {
        return client.get("$BASE_URL/3/movie/$movieId/credits") {
            addLanguageParameter()
        }.body()
    }

    suspend fun getVideos(movieId: Int): VideosListResponse {
        return client.get("$BASE_URL/3/movie/$movieId/videos") {
            this.addLanguageParameter()
        }.body()
    }

    private fun HttpRequestBuilder.addLanguageParameter(language: String = "pt-BR") {
        parameter("language", language)
    }
}