package com.nawrot.mateusz.oversearch.search.question

import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.View
import com.nawrot.mateusz.oversearch.R
import com.nawrot.mateusz.oversearch.domain.question.model.Question
import kotlinx.android.synthetic.main.item_question.view.*


class QuestionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private var questionRowInterface: QuestionRowInterface? = null

    lateinit var question: Question

    fun bind(question: Question, questionRowInterface: QuestionRowInterface?) {
        this.question = question
        this.questionRowInterface = questionRowInterface

        itemView.apply {
            questionRank.text = question.rank.toString()
            questionTitle.text = question.title
            questionOwner.text = context.getString(R.string.created_by_placeholder, question.owner)
            questionTags.text = question.tags.joinToString(separator = ", ")
            questionRank.background = ContextCompat.getDrawable(context, if (question.answerId != null) R.drawable.score_background_selected else R.drawable.score_background)
            questionRank.setTextColor(ContextCompat.getColor(context, if (question.answerId != null) R.color.white else R.color.gray))
        }
    }

}