package com.example.myapplication.presentation.signupscreen.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignUpViewmodel @Inject constructor(

) : ViewModel() {

    fun signUp(user:String,email:String,password:String,confirmPassword:String):Boolean{

        if(user.trim().isEmpty() || email.trim().isEmpty() || password.trim().isEmpty() || confirmPassword.trim().isEmpty()){
            return false
        }
        else{
            return true
        }
    }
}