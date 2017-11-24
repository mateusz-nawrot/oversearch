package com.nawrot.mateusz.oversearch.domain.base.usecase

import com.nawrot.mateusz.oversearch.domain.base.SchedulersProvider
import io.reactivex.Observable


abstract class ObservableUseCase<in P, R>(private val schedulersProvider: SchedulersProvider) {

    private lateinit var observable: Observable<R>

    fun execute(param: P): Observable<R> {
        observable = createUseCaseObservable(param).compose(schedulersProvider.observableTransformer())
        return observable
    }

    protected abstract fun createUseCaseObservable(param: P): Observable<R>

}