package com.example.di

import com.example.data.repository.RemoteRepository
import com.example.domain.UsecaseGetEarthquakeData
import org.koin.dsl.module

val repositoriesModule = module {
    single { RemoteRepository() }
    factory { UsecaseGetEarthquakeData(get()) }
}