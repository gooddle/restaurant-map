package org.example.restaurant.domain.user.dto

data class SignInRequest(
    val email: String,
    val password: String
)