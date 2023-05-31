package com.example.mycurrency.main_page.ui

import android.content.ContentValues
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.example.mycurrency.databinding.FragmentLoginBinding
import com.example.mycurrency.utils.extensions.replace
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import timber.log.Timber

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        clickButtonSingIn()
        clickButtonRegister()
    }

    override fun onDestroy() {
        super.onDestroy()
        activity?.finish()
    }



    private fun clickButtonRegister() {
        with(binding) {
            progressView.isVisible = false
            buttonToRegister.setOnClickListener {
                replace(RegistrationFragment())
                progressView.isVisible = true
            }
        }
    }

    private fun clickButtonSingIn() {
        with(binding) {
            buttonSignIn.setOnClickListener {
                val email = editTextEmail.text.toString()
                val password = editTextPassword.text.toString()

                if (email.isEmpty()) {
                    Toast.makeText(requireContext(), "Enter Email", Toast.LENGTH_LONG).show()
                    return@setOnClickListener
                }
                if (password.length < 8) {
                    Toast.makeText(
                        requireContext(),
                        "the password must be more than 8 characters",
                        Toast.LENGTH_LONG
                    ).show()
                    return@setOnClickListener
                }
                progressView.isVisible = true
                Firebase.auth.signInWithEmailAndPassword(email, password).addOnCompleteListener() { task ->
                    if (task.isSuccessful) {
                        Timber.tag(ContentValues.TAG).d("$email hello in your account")
                        replace(MainFragment())
                    } else {
                        Toast.makeText(
                            requireContext(),
                            "incorrect login or password",
                            Toast.LENGTH_SHORT,
                        ).show()
                        progressView.isVisible = false
                    }
                }
            }
        }
    }

}
