package com.example.recycleviewdemo

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recycleviewdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val recycleViewAdapter = RecycleViewAdapter()
        binding.rvView.adapter = recycleViewAdapter
//      binding.rvView.layoutManager = LinearLayoutManager(this)

        binding.btnSubmit.setOnClickListener {
            val name = binding.etName.text.toString()
            val text = binding.etText.text.toString()
            if (name.isNotEmpty() && text.isNotEmpty()) {
                val m = Message(name, text)
                recycleViewAdapter.getItem(m)

                binding.etName.setText("")
                binding.etText.setText("")
            }
            else {
                Toast.makeText(this,
                    "Enter all inputs",
                    Toast.LENGTH_LONG
                ).show()
            }
        }


    }
}