package br.com.havan.common.domain.repository

import br.com.havan.common.domain.model.LoginModel
import br.com.havan.common.domain.usecase.logar.LogarUseCaseImpl.Params as LogarParams

interface LoginRepository {
    suspend fun logar(logarParams: LogarParams) : LoginModel
}