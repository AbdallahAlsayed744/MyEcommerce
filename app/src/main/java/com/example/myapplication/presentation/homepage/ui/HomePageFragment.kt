package com.example.myapplication.presentation.homepage.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentHomePageBinding
import com.example.myapplication.presentation.homepage.adapter.HomeCategoryAdapter
import com.example.myapplication.presentation.homepage.viewmodel.HomePageViewmodel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@AndroidEntryPoint
class HomePageFragment : Fragment() {
    private var _binding: FragmentHomePageBinding? = null
    private val binding get() = _binding!!

    val vmodel : HomePageViewmodel by viewModels()

    lateinit var adapter: HomeCategoryAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomePageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = HomeCategoryAdapter()




        // Set up the RecyclerView first
        binding.categoryRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            adapter = adapter
            setHasFixedSize(true)
        }

        lifecycleScope.launch(Dispatchers.IO) {
            vmodel.categories.collect { categories ->
                Log.d("mydata", "onViewCreated: $categories")
                adapter.updateCategories(categories)
            }
        }
    }


//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        adapter = HomeCategoryAdapter()
//
//        lifecycleScope.launch(Dispatchers.IO) {
//            vmodel.categories.collect{
//
//
//                adapter.differ.submitList(it)
//                withContext(Dispatchers.Main){
//                    binding.categoryRecyclerView.apply {
//                        adapter=adapter
//                        hasFixedSize()
//                        layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
//                    }
//                }
//            }
//        }
//
//
//    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}