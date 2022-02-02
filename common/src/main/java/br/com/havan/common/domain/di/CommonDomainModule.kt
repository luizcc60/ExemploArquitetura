package br.com.havan.common.domain.di

import br.com.havan.common.domain.usecase.logar.LogarUseCase
import br.com.havan.common.domain.usecase.logar.LogarUseCaseImpl
import org.koin.dsl.module

val useCase = module {
    factory<LogarUseCase> {
        LogarUseCaseImpl(get())
    }
}
val commonDomainModule = listOf(useCase)