package br.com.havan.common.data.remote.source.login

interface LoginRemoteDataSource {
    suspend fun logar(codigo: String, senha: String): LoginResponseModel
}