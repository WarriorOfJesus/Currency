package com.example.mycurrency.root

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mycurrency.databinding.ActivityMainBinding
import com.example.mycurrency.main_page.ui.LoginFragment
import com.example.mycurrency.main_page.ui.MainFragment
import com.example.mycurrency.main_page.ui.MainPageViewModel
import com.example.mycurrency.utils.Constants
import com.example.mycurrency.utils.replace
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import org.koin.android.ext.android.inject

class RootActivity : AppCompatActivity() {

    private val mAuth : FirebaseAuth = FirebaseAuth.getInstance()
    private val binding : ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        replace(LoginFragment())
    }

    override fun onStart() {
        super.onStart()
        var currentUser = mAuth.currentUser
        checkUser(currentUser)
    }

    private fun checkUser(currentUser:  FirebaseUser?){
        if(currentUser != null){
            replace(MainFragment())
        }else replace(LoginFragment())
    }
}