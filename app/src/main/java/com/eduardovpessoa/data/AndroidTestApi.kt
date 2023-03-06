package com.eduardovpessoa.data

import com.eduardovpessoa.data.dto.Profiles
import retrofit2.Response
import retrofit2.http.GET

interface AndroidTestApi {
    @GET("main/androidtest.json")
    suspend fun getProfiles() : Response<Profiles>
}