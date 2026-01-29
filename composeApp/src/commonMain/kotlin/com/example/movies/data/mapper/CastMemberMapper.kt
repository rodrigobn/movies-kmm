package com.example.movies.data.mapper

import com.example.movies.data.network.IMAGE_BASE_URL
import com.example.movies.data.network.model.CastMemberResponse
import com.example.movies.domain.model.CastMember
import com.example.movies.domain.model.ImageSize

fun CastMemberResponse.toModel(): CastMember {
    return CastMember(
        id = this.id,
        mainRole = this.department,
        name = this.name,
        character = this.character,
        profileUrl = "$IMAGE_BASE_URL/${ImageSize.X_SMALL.size}${this.profilePath}"
    )
}