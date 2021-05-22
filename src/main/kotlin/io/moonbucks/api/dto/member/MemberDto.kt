package io.moonbucks.api.dto.member

import io.moonbucks.api.entity.member.Member
import java.util.*

data class MemberDto(
    val id: Long? = 0,
    val uuid: String? = "",
    val type: String? = "",
    val activated: Boolean? = false,
    val password: String? = "",
    var displayName: String? = "",
    var email: String? = "",
    val state: String? = "",
    val createdAt: Date? = Date(),
    val updatedAt: Date? = Date()
)
