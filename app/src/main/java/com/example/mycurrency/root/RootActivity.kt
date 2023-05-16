package com.example.mycurrency.root

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mycurrency.databinding.ActivityMainBinding
import com.example.mycurrency.main_page.ui.MainFragment
import com.example.mycurrency.main_page.ui.MainPageViewModel
import com.example.mycurrency.utils.Constants
import com.example.mycurrency.utils.replace
import org.koin.android.ext.android.inject

class RootActivity : AppCompatActivity() {

    private val binding : ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        replace(MainFragment())


    }
}