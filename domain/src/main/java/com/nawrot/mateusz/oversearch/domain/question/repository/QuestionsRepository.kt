package com.nawrot.mateusz.oversearch.domain.question.repository

import com.nawrot.mateusz.oversearch.domain.question.model.Question
import io.reactivex.Observable


interface QuestionsRepository {

    fun getQuestions(query: String, order: String = "desc", sort: String = "relevance"): Observable<List<Question>>

}