package com.nawrot.mateusz.oversearch.domain.question.usecase

import com.nawrot.mateusz.oversearch.domain.base.SchedulersProvider
import com.nawrot.mateusz.oversearch.domain.base.usecase.ObservableUseCase
import com.nawrot.mateusz.oversearch.domain.question.model.Question
import com.nawrot.mateusz.oversearch.domain.question.repository.QuestionsRepository
import io.reactivex.Observable
import javax.inject.Inject


class GetQuestionsUseCase @Inject constructor(schedulersProvider: SchedulersProvider,
                                              private val questionsRepository: QuestionsRepository) : ObservableUseCase<String, List<Question>>(schedulersProvider) {

    override fun createUseCaseObservable(query: String): Observable<List<Question>> {
        return questionsRepository.getQuestions(query)
    }
}