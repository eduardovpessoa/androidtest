package com.eduardovpessoa.data.remote

import com.eduardovpessoa.data.AndroidTestApi
import com.eduardovpessoa.data.dto.Profiles
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class ProfileRepository(
    private val api: AndroidTestApi,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) {
    suspend fun getProfiles(): Response<Profiles> {
        return withContext(dispatcher) {
            api.getProfiles()
        }
    }
}