package org.example.restaurant.domain.user.dto

import org.example.restaurant.domain.user.model.User

data class SignUpResponse(
    val id: Long,
    val email: String,
    val role: String
) {
    companion object {
        fun from(user: User): SignUpResponse {
            return SignUpResponse(
                id = user.id!!,
                email = user.email,
                role = user.role.toString()
            )
        }
    }
}