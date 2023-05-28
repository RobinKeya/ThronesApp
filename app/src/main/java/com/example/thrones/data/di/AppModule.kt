package com.example.thrones.data.di

import com.example.thrones.data.remote.ThronesApiService
import com.squareup.moshi.Moshi
import com.squareup.moshi.addAdapter
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    fun getThronesApiService(): ThronesApiService{
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
        return Retrofit.Builder()
            .baseUrl("https://thronesapi.com")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
            .create(ThronesApiService::class.java)
    }
}