package org.example.restaurant.domain.user.service

import org.example.restaurant.domain.user.dto.SignUpRequest
import org.example.restaurant.domain.user.dto.SignUpResponse
import org.example.restaurant.domain.user.model.User
import org.example.restaurant.domain.user.repository.UserRepository
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class UserService (
    private val passwordEncoder: PasswordEncoder,
    private val userRepository: UserRepository
) {

    fun signUp(request: SignUpRequest ): SignUpResponse {
        val user = userRepository.findByEmail(request.email)
        if (user != null) {
            throw IllegalStateException("User already exists")
        }
        val newUser = User(
            email = request.email,
            password = passwordEncoder.encode(request.password),
            createdAt = LocalDateTime.now()
        )
        return SignUpResponse.from(newUser)
    }
}