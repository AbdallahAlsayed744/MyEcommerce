package com.example.myapplication.presentation.homepage.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.domain.model.mycategory
import com.example.myapplication.domain.repo.CategoreiesRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomePageViewmodel @Inject constructor (
    private val catogry:CategoreiesRepo
): ViewModel() {

    private var _categories = MutableStateFlow<List<String>>(emptyList())
    val categories:StateFlow<List<String>> get()  = _categories

    init {
        viewModelScope.launch {
            getallcategories()
        }

    }


    suspend fun getallcategories() {
        try {
           val response = catogry.getallcategories()
            if(response.isSuccessful&&response.body()!=null){
                _categories.value = response.body()!!
            }

        }catch (e:Exception){
            e.printStackTrace()
        }

    }





}