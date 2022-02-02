package br.com.havan.common.data.remote.di

import br.com.havan.common.data.remote.retrofit.RetrofitInstance
import br.com.havan.common.data.remote.service.LoginService
import br.com.havan.common.data.remote.source.login.LoginRemoteDataSource
import br.com.havan.common.data.remote.source.login.LoginRemoteDataSourceImpl
import org.koin.dsl.module

val remoteModule = module {
    single { RetrofitInstance.provideOkHttpClient() }
    single { RetrofitInstance.create(get(), "https://sistema.havan.com.br/autenticacaoapi/") as LoginService }
    factory<LoginRemoteDataSource> { LoginRemoteDataSourceImpl(get()) }
}

val commonRemoteModule = listOf(remoteModule)