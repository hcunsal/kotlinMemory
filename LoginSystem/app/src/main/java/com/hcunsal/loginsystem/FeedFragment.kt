package com.hcunsal.loginsystem

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hcunsal.loginsystem.databinding.FragmentFeedBinding
import com.hcunsal.loginsystem.databinding.FragmentLoginBinding


class FeedFragment : Fragment() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    private var _binding : FragmentFeedBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentFeedBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        arguments?.let {
            val name = FeedFragmentArgs.fromBundle(it).name
            val surname = FeedFragmentArgs.fromBundle(it).surname

            binding.nameText.text = name
            binding.surnameText.text = surname
        }


    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}