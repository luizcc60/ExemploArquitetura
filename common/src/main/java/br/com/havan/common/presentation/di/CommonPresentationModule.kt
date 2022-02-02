package br.com.havan.common.presentation.di

import br.com.havan.common.presentation.login.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModels = module {
    viewModel { LoginViewModel(get()) }
}

val commonPresentationModule = listOf(viewModels)