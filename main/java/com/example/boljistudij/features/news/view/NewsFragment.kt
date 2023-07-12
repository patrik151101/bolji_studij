package com.example.boljistudij.features.news.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.boljistudij.R
import com.example.boljistudij.databinding.FragmentNewsBinding
import com.example.boljistudij.extensions.observe
import com.example.boljistudij.features.home.view.NewsAdapter
import com.example.boljistudij.features.news.viewmodel.NewsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsFragment : Fragment(R.layout.fragment_news)  {

    private val viewBinding: FragmentNewsBinding by viewBinding(FragmentNewsBinding::bind)
    private val viewModel: NewsViewModel by viewModels()

    private var newsAdapter: NewsAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeAdapters()
        setRecycleView()
        observeState()
        backButton()
    }

    private fun initializeAdapters() {
        newsAdapter = NewsAdapter(context = requireContext())
    }

    private fun observeState() {
        viewModel.uiStateFlow.observe(viewLifecycleOwner) { uiState ->
            newsAdapter?.submitList(uiState.listNews)
        }
    }

    private fun backButton() {
        viewBinding.backButton.setOnClickListener {
            findNavController().popBackStack()
        }
    }



    private fun setRecycleView() {
        viewBinding.newsList.apply {
            adapter = newsAdapter
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
            setHasFixedSize(true)
        }
    }
}