package com.hcunsal.loginsystem

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.hcunsal.loginsystem.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    private var _binding : FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button.setOnClickListener {
            val name = binding.name.text.toString()
            val surname = binding.surname.text.toString()
            val action = LoginFragmentDirections.actionLoginFragmentToFeedFragment(name, surname)
            Navigation.findNavController(it).navigate(action)
        }


    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}