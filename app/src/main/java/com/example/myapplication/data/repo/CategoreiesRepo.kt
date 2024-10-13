package com.example.myapplication.data.repo

import android.util.Log
import com.example.myapplication.data.remote.api
import com.example.myapplication.domain.model.mycategory
import com.example.myapplication.domain.repo.CategoreiesRepo
import retrofit2.Response
import javax.inject.Inject

class CategoreiesRepoimpl (
    private val myapi: api
)  :CategoreiesRepo {


    override suspend fun getallcategories(): Response<mycategory> {
        val response = myapi.getallcategories()
        if(response.isSuccessful&&response.body()!=null){
            Log.d("response succefull",response.body().toString())
        }
        else{
            Log.d("response fail",response.body().toString())
        }
        return response
    }
}