package com.example.signupdemo

import android.os.Bundle
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.signupdemo.databinding.FragmentEmainBinding
import com.example.signupdemo.databinding.FragmentHomeBinding

class emainFragment : Fragment() {

    private lateinit var binding : FragmentEmainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEmainBinding.inflate(inflater, container, false)
        val inputName = requireArguments().getString("user_name")

        binding.btnContinue2.setOnClickListener {
            if (binding.eEmail.text.toString() == "") {
                Toast.makeText(context, "Enter your email ${inputName}", Toast.LENGTH_SHORT).show()
            }
            else {
                if (Patterns.EMAIL_ADDRESS.matcher(binding.eEmail.text).matches()) {
                    findNavController().navigate(R.id.action_emainFragment_to_lastPage)
                }
                else {
                    Toast.makeText(context, "Enter your email correct ${inputName}", Toast.LENGTH_SHORT).show()
                }
            }
        }

        return binding.root
    }


}