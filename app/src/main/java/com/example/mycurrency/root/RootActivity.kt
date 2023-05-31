package com.example.mycurrency.root

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mycurrency.databinding.ActivityMainBinding
import com.example.mycurrency.main_page.ui.LoginFragment
import com.example.mycurrency.main_page.ui.MainFragment
import com.example.mycurrency.utils.extensions.replace
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class RootActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        replace(LoginFragment())
    }


    override fun onResume() {
        super.onResume()
        checkUser()
    }

    private fun checkUser() {
        val user = Firebase.auth.currentUser
        if (user != null) {
            replace(MainFragment())
        } else replace(LoginFragment())
    }


}