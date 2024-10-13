package com.example.myapplication.presentation.signupscreen.ui

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentSignUpScreenBinding
import com.example.myapplication.presentation.homescreen.ui.HomeActivity
import com.example.myapplication.presentation.signupscreen.viewmodel.SignUpViewmodel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class SignUpScreenFragment : Fragment() {

    private var _binding: FragmentSignUpScreenBinding? = null
    private  val binding get() = _binding!!

    val vmodel by viewModels<SignUpViewmodel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSignUpScreenBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.SigninButton.setOnClickListener {
            findNavController().navigate(R.id.action_signUpScreenFragment_to_signInFragment)
        }

        checksignup()

    }

    private fun checksignup() {
        binding.SignUpButton.setOnClickListener {
            val user = binding.fullNameEdittext.editText?.text.toString()
            val email = binding.emailedittextSignup.editText?.text.toString()
            val password =binding.PaswordedittextSignup.editText?.text.toString()
            val confirmPassword =binding.ConfirmPaswordedittextSignup.editText?.text.toString()

            if(vmodel.signUp(user,email,password,confirmPassword)){
               startActivity(Intent(requireContext(),HomeActivity::class.java))
            }

            if (user.trim().isEmpty()) {
                binding.fullNameEdittext.error = "Please enter a valid username"
                binding.fullNameEdittext.editText?.setBackgroundResource(R.drawable.error_background)

            }
            if (email.trim().isEmpty()) {
                binding.emailedittextSignup.error = "Please enter a valid email"
                binding.emailedittextSignup.editText?.setBackgroundResource(R.drawable.error_background)

            }
            if (password.trim().isEmpty()) {
                binding.PaswordedittextSignup.error = "Please enter a valid password"
                binding.PaswordedittextSignup.editText?.setBackgroundResource(R.drawable.error_background)

            }
            if (confirmPassword.trim().isEmpty()) {
                binding.ConfirmPaswordedittextSignup.error = "Please enter a valid password"
                binding.ConfirmPaswordedittextSignup.editText?.setBackgroundResource(R.drawable.error_background)

            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding =null
    }


}