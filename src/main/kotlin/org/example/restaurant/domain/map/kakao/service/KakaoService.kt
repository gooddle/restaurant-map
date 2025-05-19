package org.example.restaurant.domain.map.kakao.service

import org.example.restaurant.domain.map.kakao.dto.KakaoKeywordSearchResponse
import org.example.restaurant.domain.user.repository.UserRepository
import org.example.restaurant.infra.kakao.KakaoMapUtil
import org.springframework.stereotype.Service

@Service
class KakaoService(
    private val kakaoMapUtil: KakaoMapUtil,
    private val userRepository: UserRepository
) {

    fun get(
        keyword: String,
        userId: Long
    ): KakaoKeywordSearchResponse? {
        val user = userRepository.findById(userId) ?: throw IllegalArgumentException("User with id $userId not found")
        return kakaoMapUtil.searchPlaceByKeyword(keyword)
    }
}