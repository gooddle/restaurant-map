package org.example.restaurant.domain.user.controller

import org.example.restaurant.domain.user.dto.SignInRequest
import org.example.restaurant.domain.user.dto.SignInResponse
import org.example.restaurant.domain.user.dto.SignUpRequest
import org.example.restaurant.domain.user.dto.SignUpResponse
import org.example.restaurant.domain.user.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/users")
class UserController(
    private val userService: UserService
) {

    @PostMapping("/signup")
    fun signUp(@RequestBody request: SignUpRequest): ResponseEntity<SignUpResponse> {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.signUp(request))
    }

    @PostMapping("/signIn")
    fun signIn(@RequestBody request: SignInRequest): ResponseEntity<SignInResponse> {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.signIn(request))
    }
}