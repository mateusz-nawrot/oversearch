package com.nawrot.mateusz.oversearch.data.question.model

import com.squareup.moshi.Json


data class QuestionDto(

        @Json(name = "question_id")
        val questionId: Int,

        @Json(name = "title")
        val title: String?,

        @Json(name = "tags")
        val tags: List<String>,

        @Json(name = "owner")
        val owner: UserDto?,

        @Json(name = "is_answered")
        val isAnswered: Boolean,

        @Json(name = "view_count")
        val viewCount: Int,

        @Json(name = "accepted_answer_id")
        val acceptedAnswerId: Int?,

        @Json(name = "answer_count")
        val answerCount: Int = 0,

        @Json(name = "score")
        val score: Int = 0,

        @Json(name = "last_activity_date")
        val lastActivityDate: Long,

        @Json(name = "creation_date")
        val creationDate: Long,

        @Json(name = "last_edit_date")
        val lastEditDate: Long?,

        @Json(name = "link")
        val link: String

)