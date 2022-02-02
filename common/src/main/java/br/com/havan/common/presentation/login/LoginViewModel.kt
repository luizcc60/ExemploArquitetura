package br.com.havan.common.presentation.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.havan.common.domain.model.LoginModel
import br.com.havan.common.domain.usecase.logar.LogarUseCase
import kotlinx.coroutines.*
import br.com.havan.common.domain.usecase.logar.LogarUseCaseImpl.Params as LogarParams


class LoginViewModel(private val logarUseCase: LogarUseCase) : ViewModel() {

    private val _loginViewState = MutableLiveData<LoginModel>()
    val loginViewState: LiveData<LoginModel> = _loginViewState

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoadingViewState: LiveData<Boolean> = _isLoading

    private val _exception = MutableLiveData<Throwable>()
    val exceptionViewState: LiveData<Throwable> = _exception

    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        exibirLoading()
        _exception.postValue(throwable)
    }

    fun autenticar(codigo: String, senha: String) {
        viewModelScope.launch(exceptionHandler) {
            exibirLoading(true)
            _loginViewState.value = withContext(Dispatchers.Main) {
                logarUseCase.logar(
                    LogarParams(codigo, senha)
                )
            }
            exibirLoading()
        }
    }

    fun exibirLoading(exibir: Boolean = false){
        _isLoading.value = exibir
    }
}