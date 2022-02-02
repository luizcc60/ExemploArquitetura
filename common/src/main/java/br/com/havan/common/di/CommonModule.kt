package br.com.havan.common.di

import br.com.havan.common.data.di.commonRepositoryModule
import br.com.havan.common.data.remote.di.commonRemoteModule
import br.com.havan.common.domain.di.commonDomainModule
import br.com.havan.common.presentation.di.commonPresentationModule

val commonModule = (commonPresentationModule + commonDomainModule + commonRepositoryModule + commonRemoteModule)