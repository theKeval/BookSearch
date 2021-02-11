package com.example.booksearch.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.booksearch.R
import com.example.booksearch.databinding.FragmentSearchBinding
import com.example.booksearch.viewmodels.SearchViewModel

class SearchFragment : Fragment() {

    private lateinit var binding: FragmentSearchBinding

    private val viewModel: SearchViewModel by lazy {
        ViewModelProvider(this).get(SearchViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // any of below line will work, but I'm not sure what is the difference :(
        // now i know the difference :)
        // https://stackoverflow.com/questions/51893495/android-databinding-databindingutil-vs-binding-class
        // use generated databinding class if available - recommended by documentation

        // binding = DataBindingUtil.inflate(inflater, R.layout.fragment_search, container,false)
        binding = FragmentSearchBinding.inflate(inflater)

        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        

        return binding.root
    }
}