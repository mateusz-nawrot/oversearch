package com.nawrot.mateusz.oversearch.question

import com.nawrot.mateusz.oversearch.domain.question.model.Question


interface QuestionRowInterface {

    fun onQuestionClick(question: Question)

}