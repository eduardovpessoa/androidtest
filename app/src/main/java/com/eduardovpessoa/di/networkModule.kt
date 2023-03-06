package com.eduardovpessoa.di

import com.eduardovpessoa.data.AndroidTestApi
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit

@ExperimentalSerializationApi
val networkModule = module {
    single { provideOkHttpClient() }
    single { provideDivvyTestApi(retrofit = get()) }
    single { provideRetrofit(okHttpClient = get()) }
}

private fun provideOkHttpClient(): OkHttpClient {
    return OkHttpClient.Builder()
        .connectTimeout(15L, TimeUnit.SECONDS)
        .readTimeout(15L, TimeUnit.SECONDS)
        .writeTimeout(15L, TimeUnit.SECONDS)
        .build()
}

private fun provideDivvyTestApi(retrofit: Retrofit): AndroidTestApi =
    retrofit.create(AndroidTestApi::class.java)

@ExperimentalSerializationApi
private fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    val contentType = "application/json".toMediaType()
    return Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory(contentType))
        .baseUrl("https://raw.githubusercontent.com/eduardovpessoa/divvy/")
        .client(okHttpClient)
        .build()
}