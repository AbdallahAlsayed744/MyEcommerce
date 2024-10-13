package com.example.myapplication.data.remote

import com.example.myapplication.domain.model.mycategory
import retrofit2.Response

import retrofit2.http.GET

interface api {

    @GET("products/categories")
    suspend fun getallcategories(): Response<mycategory>




}
