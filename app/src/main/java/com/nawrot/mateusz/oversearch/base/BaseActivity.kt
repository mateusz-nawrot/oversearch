package com.nawrot.mateusz.oversearch.base

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import kotlin.reflect.KClass


open class BaseActivity : AppCompatActivity() {

    inline fun <reified T : Any> start(activityClass: KClass<T>, flags: Int? = null, finishCurrentActivity: Boolean = false) {
        val intent = Intent(this, activityClass.java)

        flags?.let { intent.flags = flags }

        if (finishCurrentActivity) finish()

        startActivity(intent)
    }

    fun initToolbar(toolbar: Toolbar, navigationIconEnabled: Boolean? = null) {
        setSupportActionBar(toolbar)
        navigationIconEnabled?.let { supportActionBar?.setDisplayHomeAsUpEnabled(navigationIconEnabled) }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}