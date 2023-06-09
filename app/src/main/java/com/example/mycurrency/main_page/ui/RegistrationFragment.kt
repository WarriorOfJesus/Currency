package com.example.mycurrency.main_page.ui

import android.content.ContentValues.TAG
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.example.mycurrency.R
import com.example.mycurrency.common.mvvm.BaseFragment
import com.example.mycurrency.databinding.FragmentRegistrationBinding
import com.example.mycurrency.utils.extensions.replace
import com.example.mycurrency.utils.extensions.viewbinding.viewBinding
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import timber.log.Timber

class RegistrationFragment : BaseFragment(R.layout.fragment_registration) {


    private val binding: FragmentRegistrationBinding by viewBinding()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            progressView.isVisible = false
            buttonRegister.setOnClickListener {
                val email = editTextEmail.text.toString()
                val password = editTextPassword.text.toString()
                if (email.isEmpty()) {
                    Toast.makeText(requireContext(), "Enter Email", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
                if (password.isEmpty()) {
                    Toast.makeText(requireContext(), "Enter password ", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
                progressView.isVisible = true
                Firebase.auth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task ->

                        if (task.isSuccessful) {
                            // Sign in success, update UI with the signed-in user's information
                            Timber.tag(TAG).d("Account created")
                            replace(MainFragment())
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(
                                requireContext(),
                                "account already exists",
                                Toast.LENGTH_SHORT,
                            ).show()
                            progressView.isVisible = false
                        }
                    }
            }
        }
    }
}