package com.nawrot.mateusz.oversearch.search

import android.os.Bundle
import android.util.Log
import android.view.inputmethod.EditorInfo
import com.jakewharton.rxbinding2.widget.editorActions
import com.nawrot.mateusz.oversearch.R
import com.nawrot.mateusz.oversearch.base.BaseActivity
import com.nawrot.mateusz.oversearch.base.addToCompositeDisposable
import com.nawrot.mateusz.oversearch.base.hideKeyboard
import com.nawrot.mateusz.oversearch.base.showSnackbar
import com.nawrot.mateusz.oversearch.domain.question.model.Question
import com.nawrot.mateusz.oversearch.search.question.QuestionRowInterface
import com.nawrot.mateusz.oversearch.search.question.QuestionsAdapter
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_search.*
import javax.inject.Inject

class SearchActivity : BaseActivity(), SearchView, QuestionRowInterface {

    @Inject
    lateinit var presenter: SearchPresenter

    private lateinit var questionsAdapter: QuestionsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        setSupportActionBar(toolbar)

        searchEditText.editorActions().subscribe { it ->
            when (it) {
                EditorInfo.IME_ACTION_SEARCH -> {
                    searchEditText.hideKeyboard()
                    presenter.search()
                }
            }
        }.addToCompositeDisposable(viewDisposable)

        questionsAdapter = QuestionsAdapter()

        questionsRecyclerView.adapter = questionsAdapter

    }

    override fun onStart() {
        super.onStart()
        presenter.attachView(this)
    }

    override fun onStop() {
        super.onStop()
        presenter.detachView()
    }

    override fun onDestroy() {
        super.onDestroy()
        questionsAdapter.questionRowInterface = null
    }

    override fun getQuery(): String {
        return searchEditText.text.toString()
    }

    override fun showError(error: Throwable) {
        Log.d("SearchActivity", Log.getStackTraceString(error))
        searchCoordinator.showSnackbar(getString(R.string.error_generic))
    }

    override fun showResults(questions: List<Question>) {
        questionsRecyclerView.scheduleLayoutAnimation()
        questionsAdapter.swapData(questions)
    }

    override fun onQuestionClick(question: Question) {

    }
}
