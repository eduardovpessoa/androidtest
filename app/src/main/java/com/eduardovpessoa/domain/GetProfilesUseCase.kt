package com.eduardovpessoa.domain

import android.util.Log
import com.eduardovpessoa.data.dto.Profiles
import com.eduardovpessoa.data.remote.ProfileRepository
import com.eduardovpessoa.ui.profiles.ProfilesScreenUI
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetProfilesUseCase constructor(private val repository: ProfileRepository) {
    suspend operator fun invoke(): Flow<ProfilesScreenUI> = flow {
        try {
            repository.getProfiles().run {
                if (isSuccessful) {
                    body()?.let { resp ->
                        emit(mapResponseToUI(resp))
                    }
                }
            }
        } catch (ex: Exception) {
            Log.e(GetProfilesUseCase::class.java.name, ex.message.orEmpty())
        }
    }


    private fun mapResponseToUI(response: Profiles): ProfilesScreenUI {
        return ProfilesScreenUI(
            profiles = response.people?.toList()!!
        )
    }
}