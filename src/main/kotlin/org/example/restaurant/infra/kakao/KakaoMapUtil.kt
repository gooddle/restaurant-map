package org.example.restaurant.infra.kakao

import org.example.restaurant.domain.map.kakao.dto.KakaoKeywordSearchResponse
import org.hibernate.annotations.Comment
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.*
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.*
import org.springframework.web.client.RestTemplate
import org.springframework.web.util.UriComponentsBuilder

@Component
class KakaoMapUtil(
    @Value("\${kakao.rest-api-key}")
    private val kakaoRestApiKey: String,
) {
    private val restTemplate = RestTemplate()

    fun searchPlaceByKeyword(keyword: String): KakaoKeywordSearchResponse? {
        val uri = UriComponentsBuilder
            .fromHttpUrl("https://dapi.kakao.com/v2/local/search/keyword.json")
            .queryParam("query", keyword)
            .build()
            .encode()
            .toUri()

        val headers = HttpHeaders().apply {
            set("Authorization", "KakaoAK $kakaoRestApiKey")
        }

        val entity = HttpEntity<Void>(headers)

        val response = restTemplate.exchange(
            uri,
            HttpMethod.GET,
            entity,
            KakaoKeywordSearchResponse::class.java
        )

        return response.body
    }
}