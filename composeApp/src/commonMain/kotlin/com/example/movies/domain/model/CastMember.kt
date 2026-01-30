package com.example.movies.domain.model

/**
 * Classe de representação de um membro do elenco de um filme.
 * @param id O identificador único do membro do elenco.
 * @param mainRole O papel principal ou departamento do membro do elenco.
 * @param name O nome do membro do elenco.
 * @param character O nome do personagem interpretado pelo membro do elenco (se aplicável).
 * @param profileUrl O caminho para a imagem de perfil do membro do elenco (se disponível
 */
data class CastMember(
    val id: Int,
    val mainRole: String,
    val name: String,
    val character: String,
    val profileUrl: String? = null
)

// fake data for preview and testing
val fakeCastMembers = listOf(
    CastMember(1, "Acting", "Actor One", "Character One", null),
    CastMember(2, "Acting", "Actor Two", "Character Two", null)
)