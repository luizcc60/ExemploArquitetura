package br.com.havan.common.domain.usecase.logar

import androidx.core.text.isDigitsOnly
import br.com.havan.common.domain.model.LoginModel
import br.com.havan.common.domain.repository.LoginRepository

class LogarUseCaseImpl(private val loginRepository: LoginRepository) : LogarUseCase {
    override suspend fun logar(model: Params): LoginModel = when {
        model.codigo.isBlank() && model.senha.isBlank() -> throw Exception(MSG_ERRO_PARAMETRO_NULO)
        model.codigo.isBlank() || !model.codigo.isDigitsOnly() -> throw Exception(MSG_ERRO_CODIGO)
        model.senha.isBlank() -> throw Exception(MSG_ERRO_SENHA)
        else -> loginRepository.logar(model)
    }

    class Params(val codigo: String, val senha: String)

    companion object {
        const val MSG_ERRO_PARAMETRO_NULO = "Preencha os campos obrigatórios!"
        const val MSG_ERRO_CODIGO = "Informe um código de usuário válido!"
        const val MSG_ERRO_SENHA = "Informe uma senha válida!"
    }
}