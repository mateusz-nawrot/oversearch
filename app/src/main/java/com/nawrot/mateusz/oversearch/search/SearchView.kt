package com.nawrot.mateusz.oversearch.search

import com.nawrot.mateusz.oversearch.base.BaseView
import com.nawrot.mateusz.oversearch.domain.question.model.Question


interface SearchView : BaseView {

    fun getQuery(): String

    fun showError(error: Throwable)

    fun showResults(questions: List<Question>)
}