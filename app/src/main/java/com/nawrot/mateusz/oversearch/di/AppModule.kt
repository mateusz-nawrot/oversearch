package com.nawrot.mateusz.oversearch.di

import android.content.Context
import com.nawrot.mateusz.oversearch.App
import com.nawrot.mateusz.oversearch.R
import com.nawrot.mateusz.oversearch.data.base.AndroidSchedulersProvider
import com.nawrot.mateusz.oversearch.data.question.repository.StackQuestionsRepository
import com.nawrot.mateusz.oversearch.domain.base.SchedulersProvider
import com.nawrot.mateusz.oversearch.domain.question.repository.QuestionsRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Named
import javax.inject.Singleton


@Module
abstract class AppModule {

    @Binds
    abstract fun bindContext(app: App): Context

    @Binds
    abstract fun schedulersProvider(androidSchedulersProvider: AndroidSchedulersProvider): SchedulersProvider

    @Binds
    abstract fun questionsRepository(stackQuestionsRepository: StackQuestionsRepository): QuestionsRepository

    @Module
    companion object {


        @JvmStatic
        @Provides
        @Named("baseUrl")
        fun baseUrl(context: Context): String {
            return context.getString(R.string.base_url)
        }

        @JvmStatic
        @Provides
        @Named("key")
        fun stackApiKey(context: Context): String {
            return context.getString(R.string.stack_client_key)
        }

        @JvmStatic
        @Provides
        @Singleton
        fun okHttpClient(): OkHttpClient {
            val builder = OkHttpClient.Builder()
            builder.retryOnConnectionFailure(true)

            val logInterceptor = HttpLoggingInterceptor()
            logInterceptor.level = HttpLoggingInterceptor.Level.BODY
            builder.addInterceptor(logInterceptor)
            return builder.build()
        }

        @JvmStatic
        @Provides
        @Singleton
        fun retrofit(okHttpClient: OkHttpClient, @Named("baseUrl") baseUrl: String): Retrofit {
            return Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(MoshiConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(okHttpClient)
                    .build()
        }

    }

}