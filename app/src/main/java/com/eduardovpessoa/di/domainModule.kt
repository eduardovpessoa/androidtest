package com.eduardovpessoa.di

import com.eduardovpessoa.domain.GetProfilesUseCase
import org.koin.dsl.module

val domainModule = module {
    factory { GetProfilesUseCase(repository = get()) }
}