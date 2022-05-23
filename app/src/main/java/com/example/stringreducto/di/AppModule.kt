package com.example.stringreducto.di

import com.example.stringreducto.domain.use_case.ReduceWord
import com.example.stringreducto.domain.use_case.VerifyInput
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun providesReduceWordUseCase() = ReduceWord()

    @Provides
    @Singleton
    fun providesVerifyInputUseCase() = VerifyInput()
}