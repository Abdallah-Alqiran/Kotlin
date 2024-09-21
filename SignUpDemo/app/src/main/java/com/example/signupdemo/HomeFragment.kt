package com.example.signupdemo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.signupdemo.databinding.FragmentHomeBinding
import org.w3c.dom.Text

var name = ""

class HomeFragment : Fragment() {

    private lateinit var binding : FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.btnSignUp.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_signUpFragment)
        }

        binding.btnTearms.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_termsPage)
        }


        return binding.root
    }

}