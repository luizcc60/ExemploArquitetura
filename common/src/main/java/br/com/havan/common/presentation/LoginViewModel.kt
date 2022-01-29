package br.com.havan.common.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.havan.common.domain.model.AutenticacaoModel
import br.com.havan.common.domain.repository.AutenticarUseCase
import kotlinx.coroutines.*
import br.com.havan.common.domain.usecase.autenticacao.autenticar.AutenticarUseCaseImpl.Params as AutenticacaoParams


class LoginViewModel(private val autenticarUseCase: AutenticarUseCase) : ViewModel() {

    private val _autenticacaoViewState = MutableLiveData<AutenticacaoModel>()
    val autenticacaoViewState: LiveData<AutenticacaoModel> = _autenticacaoViewState

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoadingViewState: LiveData<Boolean> = _isLoading

    private val _exception = MutableLiveData<Throwable>()
    val exceptionViewState: LiveData<Throwable> = _exception

    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        exibirLoading()
        _exception.postValue(throwable)
    }

    fun autenticar(codigo: String?, senha: String?) {
        viewModelScope.launch(exceptionHandler) {
            exibirLoading(true)
            delay(2000)
            _autenticacaoViewState.value = withContext(Dispatchers.Main) {
                autenticarUseCase.autenticar(
                    AutenticacaoParams(codigo, senha)
                )
            }
            exibirLoading()
        }
    }

    fun exibirLoading(exibir: Boolean = false){
        _isLoading.value = exibir
    }
}