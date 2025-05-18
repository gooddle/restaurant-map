package org.example.restaurant.domain.map.kakao.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class KakaoKeywordSearchResponse(
    val documents: List<Document>
) {
    // 카카오 맵 응답 값 json 형식 맵핑
    data class Document(
        @JsonProperty("place_name")
        val placeName: String,
        @JsonProperty("address_name")
        val addressName: String,
        @JsonProperty("road_address_name")
        val roadAddressName: String?,
        val x: String, // 경도
        val y: String  // 위도
    )
}

