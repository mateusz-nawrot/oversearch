package com.nawrot.mateusz.oversearch.data.question.model

import com.squareup.moshi.Json


data class GetQuestionsResponse(

        @Json(name = "items")
        val questions: List<QuestionDto>,

        @Json(name = "has_more")
        val hasMore: Boolean,

        @Json(name = "quota_remaining")
        val quotaRemaining: Int?,

        @Json(name = "quota_max")
        val quotaMax: Int?

)