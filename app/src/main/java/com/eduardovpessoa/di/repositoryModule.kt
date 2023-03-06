package com.eduardovpessoa.di

import com.eduardovpessoa.data.remote.ProfileRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { ProfileRepository(api = get()) }
}