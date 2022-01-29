package br.com.havan.cleanarchitecture

import android.app.Application
import br.com.havan.common.commonModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class BaseApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@BaseApplication)
            modules(
                commonModule
            )
        }
    }
}