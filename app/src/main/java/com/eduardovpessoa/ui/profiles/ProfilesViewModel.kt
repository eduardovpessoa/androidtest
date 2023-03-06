package com.eduardovpessoa.ui.profiles

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eduardovpessoa.domain.GetProfilesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ProfilesViewModel(
    private val getProfilesUseCase: GetProfilesUseCase
) : ViewModel() {

    private val _profiles: MutableStateFlow<ProfilesScreenUI> =
        MutableStateFlow(ProfilesScreenUI(emptyList()))
    val profiles = _profiles.asStateFlow()

    internal fun getProfiles() {
        viewModelScope.launch {
            getProfilesUseCase().collect {
                _profiles.value = it
            }
        }
    }
}