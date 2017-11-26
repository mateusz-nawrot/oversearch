package com.nawrot.mateusz.oversearch.domain.question.model


data class Question(val id: Int,
                    val title: String?,
                    val owner: String?,
                    val rank: Int,
                    val created: Long,
                    val tags: List<String>,
                    val answerId: Int?
)