package com.example.myapplication.presentation.loginscreen.ui

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.myapplication.MainActivity
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentSignInBinding
import com.example.myapplication.presentation.homescreen.ui.HomeActivity
import com.example.myapplication.presentation.loginscreen.viewmodel.SigninViewmodel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class SignInFragment : Fragment() {

    private var _binding: FragmentSignInBinding? = null
    private val binding get() = _binding!!

    val vmodel by viewModels<SigninViewmodel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSignInBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.registerButton.setOnClickListener {
            findNavController().navigate(R.id.action_signInFragment_to_signUpScreenFragment)
        }
        binding.SigninButton.setOnClickListener {
            val email = binding.emailedittext.editText?.text.toString()
            val password = binding.passwordedittext.editText?.text.toString()
            if (vmodel.signIn(email, password)) {
                val intent = Intent(requireContext(), HomeActivity::class.java)

                startActivity(intent)
            }

            else{
                if (email.trim().isEmpty()) {
                    binding.emailedittext.error = "Please enter a valid email"
                    //change style of emailedittext
                    binding.emailedittext.editText?.setBackgroundResource(R.drawable.error_background)




                }
                if (password.trim().isEmpty()) {
                    binding.passwordedittext.error = "Please enter a valid password"
                    binding.passwordedittext.editText?.setBackgroundResource(R.drawable.error_background)

                }
//

            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    }


