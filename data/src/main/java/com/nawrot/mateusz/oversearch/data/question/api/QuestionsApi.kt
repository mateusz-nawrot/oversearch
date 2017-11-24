package com.nawrot.mateusz.oversearch.data.question.api

import com.nawrot.mateusz.oversearch.data.question.model.GetQuestionsResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query


interface QuestionsApi {

    @GET("search/advanced?site=stackoverflow")
    fun getQuestions(@Query("order") order: String,
                     @Query("sort") sort: String,
                     @Query("q") query: String,
                     @Query("key") key: String): Observable<GetQuestionsResponse>
}