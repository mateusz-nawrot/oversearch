package com.nawrot.mateusz.oversearch.data.question.repository

import com.nawrot.mateusz.oversearch.data.question.api.QuestionsApi
import com.nawrot.mateusz.oversearch.data.question.model.GetQuestionsResponse
import com.nawrot.mateusz.oversearch.domain.question.model.Question
import com.nawrot.mateusz.oversearch.domain.question.repository.QuestionsRepository
import io.reactivex.Observable
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Named


class StackQuestionsRepository @Inject constructor(private val retrofit: Retrofit,
                                                   @Named private val apiKey: String) : QuestionsRepository {

    override fun getQuestions(query: String): Observable<List<Question>> {
        return retrofit.create(QuestionsApi::class.java)
                .getQuestions("desc", "relevance", query, apiKey)
                .map {
                    mapResponse(it)
                }
    }

    private fun mapResponse(response: GetQuestionsResponse): List<Question> {
        return arrayListOf()
    }

}