package com.eduardovpessoa

import android.app.Application
import com.eduardovpessoa.di.domainModule
import com.eduardovpessoa.di.networkModule
import com.eduardovpessoa.di.repositoryModule
import com.eduardovpessoa.di.viewModelModule
import kotlinx.serialization.ExperimentalSerializationApi
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

@ExperimentalSerializationApi
class AndroidTestApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            // Log Koin into Android logger
            androidLogger()
            // Reference Android context
            androidContext(this@AndroidTestApplication)
            // Load modules
            modules(
                modules = listOf(
                    networkModule,
                    repositoryModule,
                    domainModule,
                    viewModelModule
                )
            )
        }
    }
}