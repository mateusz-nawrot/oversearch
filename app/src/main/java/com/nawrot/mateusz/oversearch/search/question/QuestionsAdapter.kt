package com.nawrot.mateusz.oversearch.search.question

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.nawrot.mateusz.oversearch.R
import com.nawrot.mateusz.oversearch.domain.question.model.Question


class QuestionsAdapter : RecyclerView.Adapter<QuestionViewHolder>() {

    var questionRowInterface: QuestionRowInterface? = null

    private val items: MutableList<Question> = mutableListOf()

    override fun onBindViewHolder(holder: QuestionViewHolder, position: Int) {
        holder.bind(items[position], questionRowInterface)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_question, parent, false)
        return QuestionViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun swapData(newData: List<Question>) {
        items.clear()
        items.addAll(newData)
        notifyDataSetChanged()
    }
}