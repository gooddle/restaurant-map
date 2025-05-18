package org.example.restaurant.domain.user.dto

data class SignUpRequest(
    val email: String,
    val role: String,
    val password: String
)
