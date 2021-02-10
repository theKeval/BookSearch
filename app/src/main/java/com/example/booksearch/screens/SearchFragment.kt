package com.example.booksearch.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.booksearch.R
import com.example.booksearch.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {

    private lateinit var binding: FragmentSearchBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //any of below line will work, but I'm not sure what is the difference :(
        // binding = DataBindingUtil.inflate(inflater, R.layout.fragment_search, container,false)
        binding = FragmentSearchBinding.inflate(inflater)

        return binding.root
    }
}