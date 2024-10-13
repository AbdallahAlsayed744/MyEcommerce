package com.example.myapplication.presentation.loginscreen.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SigninViewmodel @Inject constructor(

): ViewModel() {


    fun signIn( email: String, password: String):Boolean {
        if (email.trim().isEmpty() || password.trim().isEmpty()) {

            return false
        }
        else {
            return true

        }


    }


}