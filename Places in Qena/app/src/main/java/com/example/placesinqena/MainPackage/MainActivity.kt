package com.example.placesinqena.MainPackage

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.placesinqena.R
import com.example.placesinqena.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // create the binding
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // check if male or female checked
        onClickedBoyOrGirl()
        // check will go to the other page or not
        binding.btnLogin.setOnClickListener {
            onClickedButton()
        }
    }

    private fun onClickedButton() {
        val name = binding.etName.text.toString()
        val password = binding.etPassword.text.toString()

        if (checkInputs(name, password)) {
            val intent: Intent = Intent(this, ContentPage::class.java)
            intent.putExtra("username", name)
            startActivity(intent)
            finish()
        }
    }

    private fun checkInputs(name: String, password: String): Boolean {
                                                                            // from gpt
        if ((name.isNotEmpty()) && (password.length >= 8) && (password.any { x -> x.isLetter() }) && (binding.rbMale.isChecked || binding.rbFemale.isChecked)) {
            return true
        } else if (name.isEmpty()) {
            Toast.makeText(this, "Please, enter your name", Toast.LENGTH_LONG).show()
        } else if (!binding.rbMale.isChecked && !binding.rbFemale.isChecked) {
            Toast.makeText(this, "Please, select your gender", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(this, "Please, enter a valid password", Toast.LENGTH_LONG).show()
        }
        return false
    }

    private fun onClickedBoyOrGirl() {
        binding.rbMale.setOnClickListener {
                                                        // from gpt
            if (binding.ivStart.drawable != ContextCompat.getDrawable(this, R.drawable.boy))
                binding.ivStart.setImageResource(R.drawable.boy)
        }

        binding.rbFemale.setOnClickListener {
                                                         // from gpt
            if (binding.ivStart.drawable != ContextCompat.getDrawable(this, R.drawable.girl))
                binding.ivStart.setImageResource(R.drawable.girl)
        }
    }


}










