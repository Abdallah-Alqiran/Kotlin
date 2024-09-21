package com.example.signupdemo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import com.example.signupdemo.databinding.FragmentSignUpBinding

class SignUpFragment : Fragment() {
    private lateinit var binding : FragmentSignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSignUpBinding.inflate(inflater, container, false)

        binding.btnContinue.setOnClickListener {
            if(binding.eName.text.toString() == "") {
                Toast.makeText(context, "Enter your name", Toast.LENGTH_SHORT).show()
            }

            else {
                val bundle = bundleOf("user_name" to binding.eName.text.toString())
                name = binding.eName.text.toString()
                it.findNavController().navigate(R.id.action_signUpFragment_to_emainFragment, bundle)
            }
        }


        return binding.root
    }


}