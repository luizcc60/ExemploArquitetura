package br.com.havan.common.data.repositoryImpl.login

import br.com.havan.common.data.remote.source.login.LoginRemoteDataSource
import br.com.havan.common.domain.model.LoginModel
import br.com.havan.common.domain.repository.LoginRepository
import br.com.havan.common.domain.usecase.logar.LogarUseCaseImpl

class LoginRepositoryImpl(private val loginDataSource: LoginRemoteDataSource) : LoginRepository {
    override suspend fun logar(logarParams: LogarUseCaseImpl.Params): LoginModel  {
        val logarResponse = loginDataSource.logar(logarParams.codigo, logarParams.senha)
        return LoginModel(logarResponse.token, logarParams.codigo)
    }
}