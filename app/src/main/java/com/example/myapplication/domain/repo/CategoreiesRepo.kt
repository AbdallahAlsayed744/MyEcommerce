package com.example.myapplication.domain.repo

import com.example.myapplication.domain.model.mycategory
import retrofit2.Response

interface CategoreiesRepo {

    suspend fun getallcategories():Response<mycategory>

}