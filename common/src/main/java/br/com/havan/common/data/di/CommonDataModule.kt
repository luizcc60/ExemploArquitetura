package br.com.havan.common.data.di

import br.com.havan.common.data.repositoryImpl.login.LoginRepositoryImpl
import br.com.havan.common.domain.repository.LoginRepository
import org.koin.dsl.module

val reposityModule = module {
    factory<LoginRepository> { LoginRepositoryImpl(get()) }
}


val commonRepositoryModule = listOf(reposityModule)