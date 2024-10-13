package com.example.myapplication.presentation.di

import com.example.myapplication.data.remote.api
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton


@Module

@InstallIn(SingletonComponent::class)
object networkmodule {

    @Provides
    @Singleton
    fun genreteretrofit():api{
        return Retrofit.Builder()
            .baseUrl("https://fakestoreapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(api::class.java)

    }






}