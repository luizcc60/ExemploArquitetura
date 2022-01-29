package br.com.havan.common.domain.usecase.autenticacao.autenticar

import br.com.havan.common.domain.model.AutenticacaoModel
import br.com.havan.common.domain.repository.AutenticarUseCase

class AutenticarUseCaseImpl : AutenticarUseCase {
    override suspend fun autenticar(model: Params): AutenticacaoModel {
        TODO("Not yet implemented")
    }

    class Params(val nome: String?, val codigo: String?)
}