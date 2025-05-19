package org.example.restaurant.domain.map.kakao.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class KakaoKeywordSearchResponse(
    @JsonProperty("meta")
    val meta: Meta,

    @JsonProperty("documents")
    val documents: List<Document>
) {
    data class Meta(
        @JsonProperty("same_name")
        val sameName: SameName,

        @JsonProperty("pageable_count")
        val pageableCount: Int,

        @JsonProperty("total_count")
        val totalCount: Int,

        @JsonProperty("is_end")
        val isEnd: Boolean
    )

    data class SameName(
        @JsonProperty("region")
        val region: List<String>,

        @JsonProperty("keyword")
        val keyword: String,

        @JsonProperty("selected_region")
        val selectedRegion: String
    )

    data class Document(
        @JsonProperty("place_name")
        val placeName: String,

        @JsonProperty("distance")
        val distance: String?,

        @JsonProperty("place_url")
        val placeUrl: String,

        @JsonProperty("category_name")
        val categoryName: String,

        @JsonProperty("address_name")
        val addressName: String,

        @JsonProperty("road_address_name")
        val roadAddressName: String?,

        @JsonProperty("id")
        val id: String,

        @JsonProperty("phone")
        val phone: String?,

        @JsonProperty("category_group_code")
        val categoryGroupCode: String?,

        @JsonProperty("category_group_name")
        val categoryGroupName: String?,

        @JsonProperty("x")
        val x: String, // 경도

        @JsonProperty("y")
        val y: String  // 위도
    )
}



