package br.com.havan.common.domain.repository

import br.com.havan.common.domain.model.AutenticacaoModel
import br.com.havan.common.domain.usecase.autenticacao.autenticar.AutenticarUseCaseImpl.Params as AutenticarParams

interface AutenticarUseCase {
    suspend fun autenticar(model: AutenticarParams): AutenticacaoModel
}