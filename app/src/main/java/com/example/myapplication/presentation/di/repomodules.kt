package com.example.myapplication.presentation.di

import com.example.myapplication.data.remote.api
import com.example.myapplication.data.repo.CategoreiesRepoimpl
import com.example.myapplication.domain.repo.CategoreiesRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object repomodules {

    @Provides
    @Singleton
    fun providecategoremodule(myapi:api): CategoreiesRepo {
        return CategoreiesRepoimpl(myapi)
    }
}