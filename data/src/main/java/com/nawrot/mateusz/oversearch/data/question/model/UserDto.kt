package com.nawrot.mateusz.oversearch.data.question.model

import com.squareup.moshi.Json


data class UserDto(

        @Json(name = "user_id")
        val userId: Int?,

        @Json(name = "user_type")
        val userType: String,

        @Json(name = "display_name")
        val displayName: String?,

        @Json(name = "profile_image")
        val profileImage: String,

        @Json(name = "accept_rate")
        val acceptRate: Int?,

        @Json(name = "reputation")
        val reputation: Int?

)