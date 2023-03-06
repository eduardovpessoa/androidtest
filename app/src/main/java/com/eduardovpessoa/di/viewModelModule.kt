package com.eduardovpessoa.di

import com.eduardovpessoa.ui.profiles.ProfilesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { ProfilesViewModel(getProfilesUseCase = get()) }
}