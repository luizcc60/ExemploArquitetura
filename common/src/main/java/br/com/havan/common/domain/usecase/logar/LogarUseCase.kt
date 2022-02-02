package br.com.havan.common.domain.usecase.logar

import br.com.havan.common.domain.model.LoginModel
import br.com.havan.common.domain.usecase.logar.LogarUseCaseImpl.Params as LogarParams

interface LogarUseCase {
    suspend fun logar(model: LogarParams): LoginModel
}