package org.example.restaurant.domain.user.service

import org.example.restaurant.domain.user.dto.SignInRequest
import org.example.restaurant.domain.user.dto.SignInResponse
import org.example.restaurant.domain.user.dto.SignUpRequest
import org.example.restaurant.domain.user.dto.SignUpResponse
import org.example.restaurant.domain.user.model.User
import org.example.restaurant.domain.user.repository.UserRepository
import org.example.restaurant.infra.security.jwt.JwtPlugin
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime

@Service
class UserService (
    private val passwordEncoder: PasswordEncoder,
    private val userRepository: UserRepository,
    private val jwtPlugin: JwtPlugin
) {

    @Transactional
    fun signUp(request: SignUpRequest ): SignUpResponse {
        if (userRepository.existsByEmail(request.email)) {
            throw IllegalStateException("User already exists")
        }
        val newUser = User(
            email = request.email,
            password = passwordEncoder.encode(request.password),
            createdAt = LocalDateTime.now()
        ).let { userRepository.save(it) }
        return SignUpResponse.from(newUser)
    }

    @Transactional
    fun signIn(request: SignInRequest ): SignInResponse {
        val user = userRepository.findByEmail(request.email) ?: throw IllegalStateException("User Not Found")
        if (!passwordEncoder.matches(request.password, user.password)) {
            throw IllegalStateException("User password mismatch")
        }
        return SignInResponse(
            token = jwtPlugin.generateAccessToken(
                subject = user.id.toString(),
                email = request.email,
                role = user.role.toString(),
            )
        )
    }
}