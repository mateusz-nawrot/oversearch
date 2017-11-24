package com.nawrot.mateusz.oversearch.di

import com.nawrot.mateusz.oversearch.search.SearchActivity
import com.nawrot.mateusz.oversearch.search.SearchActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class BuildersModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = arrayOf(SearchActivityModule::class))
    abstract fun bindSearchActivity(): SearchActivity

}