package com.example.signupdemo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.signupdemo.databinding.FragmentHomeBinding
import com.example.signupdemo.databinding.FragmentLastPageBinding
import com.example.signupdemo.databinding.FragmentSignUpBinding

class lastPage : Fragment() {

    private lateinit var binding : FragmentLastPageBinding
    private lateinit var binding2 : FragmentSignUpBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLastPageBinding.inflate(inflater, container, false)
        binding2 = FragmentSignUpBinding.inflate(inflater, container, false)

        binding.wName.text = "Welcome ${name}"

        binding.btnTerms.setOnClickListener {
            findNavController().navigate(R.id.action_lastPage_to_termsPage)
        }

        return binding.root
    }



}