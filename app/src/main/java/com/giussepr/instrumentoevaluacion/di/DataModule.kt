package com.giussepr.instrumentoevaluacion.di

import com.giussepr.instrumentoevaluacion.data.InstrumentDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideData(): InstrumentDataSource {
        return InstrumentDataSource()
    }
}
