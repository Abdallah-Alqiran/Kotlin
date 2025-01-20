package com.example.myapplication

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.databinding.ActivityTheListBinding

class TheListActivity : AppCompatActivity() {

    lateinit var binding: ActivityTheListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_the_list)

        binding = ActivityTheListBinding.inflate(layoutInflater)

        setSupportActionBar(binding.toolbar)

        binding.toolbar.setNavigationOnClickListener {

        }

    }
}