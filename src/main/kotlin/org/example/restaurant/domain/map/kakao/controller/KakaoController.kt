package org.example.restaurant.domain.map.kakao.controller

import org.example.restaurant.domain.map.kakao.dto.KakaoKeywordSearchResponse
import org.example.restaurant.domain.map.kakao.service.KakaoService
import org.example.restaurant.infra.security.UserPrincipal
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.security.Principal

@RestController
@RequestMapping("/kakao")
class KakaoController(
    private val kakaoService: KakaoService
) {

    @GetMapping("/search")
    fun get(
        @RequestParam keyword: String,
        @AuthenticationPrincipal userPrincipal: UserPrincipal
    ): ResponseEntity<List<KakaoKeywordSearchResponse.Document>> {
       return ResponseEntity.status(HttpStatus.OK).body(kakaoService.get(keyword, userPrincipal.id))
    }
}