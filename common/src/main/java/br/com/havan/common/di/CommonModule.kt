package br.com.havan.common

import br.com.havan.common.domain.di.loginDomainModule
import br.com.havan.common.presentation.di.loginPresentationModule

val commonModule = (loginPresentationModule + loginDomainModule)