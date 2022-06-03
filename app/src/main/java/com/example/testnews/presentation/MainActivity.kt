package com.example.testnews.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.testnews.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addFragment()
    }
        private fun addFragment(){
            var fragmentManager = supportFragmentManager
            var fragmetTransaction = fragmentManager.beginTransaction()

            fragmetTransaction.add(R.id.fragment_container_from_main, MainFragment())
                .commit()
    }
}