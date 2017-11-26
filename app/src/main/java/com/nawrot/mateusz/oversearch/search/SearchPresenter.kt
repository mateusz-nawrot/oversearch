package com.nawrot.mateusz.oversearch.search

import com.nawrot.mateusz.oversearch.base.BasePresenter
import com.nawrot.mateusz.oversearch.base.addToCompositeDisposable
import com.nawrot.mateusz.oversearch.domain.question.usecase.GetQuestionsUseCase
import javax.inject.Inject


class SearchPresenter @Inject constructor(private val getQuestionsUseCase: GetQuestionsUseCase) : BasePresenter<SearchView>() {

    fun search() {
        val query: String = view?.getQuery() ?: ""

        getQuestionsUseCase.execute(query)
                .doOnSubscribe { view?.setProgressVisible(true) }
                .doOnTerminate { view?.setProgressVisible(false) }
                .subscribe(
                        { results -> view?.showResults(results) },
                        { view?.showError(it) }
                ).addToCompositeDisposable(compositeDisposable)
    }

}