package br.com.havan.common.domain.di

import br.com.havan.common.domain.repository.AutenticarUseCase
import br.com.havan.common.domain.usecase.autenticacao.autenticar.AutenticarUseCaseImpl
import org.koin.dsl.module

val useCaselogin = module {
    factory<AutenticarUseCase> {
        AutenticarUseCaseImpl()
    }
}
val loginDomainModule = listOf(useCaselogin)