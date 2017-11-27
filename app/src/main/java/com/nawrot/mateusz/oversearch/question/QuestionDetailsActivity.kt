package com.nawrot.mateusz.oversearch.question

import android.os.Bundle
import com.nawrot.mateusz.oversearch.R
import com.nawrot.mateusz.oversearch.base.BaseActivity
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_search.*


class QuestionDetailsActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question_details)
        setSupportActionBar(toolbar)
    }
}