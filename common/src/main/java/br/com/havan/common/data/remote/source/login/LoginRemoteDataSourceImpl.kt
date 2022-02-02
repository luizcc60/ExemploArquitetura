package br.com.havan.common.data.remote.source.login

import br.com.havan.common.data.remote.service.LoginService

class LoginRemoteDataSourceImpl(private val loginService: LoginService): LoginRemoteDataSource {
    override suspend fun logar(codigo: String, senha: String): LoginResponseModel {
        return loginService.logar(codigo = codigo,senha = senha)
    }
}