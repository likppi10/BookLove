package com.moon.booklove_android.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.moon.booklove_android.adapter.BookCategoryAdapter
import com.moon.booklove_android.config.getRecomm
import com.moon.booklove_android.databinding.FragmentHomeBinding


private const val TAG = "HomeFragment"

class HomeFragment  : Fragment(){
    private lateinit var binding: FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bookCategoryAdapter = BookCategoryAdapter()
        //리스트 데이터 갱신(카테고리 리스트)
        bookCategoryAdapter.submitList(getRecomm())
        binding.outerRecyclerView.adapter = bookCategoryAdapter
    }

}