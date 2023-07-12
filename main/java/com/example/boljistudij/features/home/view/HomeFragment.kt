package com.example.boljistudij.features.home.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.boljistudij.R
import com.example.boljistudij.databinding.FragmentHomeBinding
import com.example.boljistudij.extensions.hideProgress
import com.example.boljistudij.extensions.observe
import com.example.boljistudij.extensions.showProgress
import com.example.boljistudij.features.home.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {

    private val viewBinding: FragmentHomeBinding by viewBinding(FragmentHomeBinding::bind)
    private val viewModel: HomeViewModel by viewModels()

    private var eventsAdapter: EventsAdapter? = null
    private var newsAdapter: NewsAdapter? = null
    private var scheduleAdapter: ScheduleAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeAdapters()
        setRecycleView()
        observeState()
        listener()
    }

    private fun initializeAdapters() {
        eventsAdapter = EventsAdapter(context = requireContext())
        newsAdapter = NewsAdapter(context = requireContext())
        scheduleAdapter = ScheduleAdapter(context = requireContext())
    }

    private fun observeState() {
        viewModel.uiStateFlow.observe(viewLifecycleOwner) { uiState ->
            eventsAdapter?.submitList(uiState.listEvent)
            newsAdapter?.submitList(uiState.listNews)
            scheduleAdapter?.submitList(uiState.listSchedule)
            if (uiState.isLoading) {
                showProgress()
            } else {
                hideProgress()
            }
        }
    }

    private fun listener() {
        viewBinding.allNewsLabel.setOnClickListener {
            findNavController().navigate(
                HomeFragmentDirections.actionHomeToNews()
            )
        }
    }

    private fun setRecycleView() {
        viewBinding.eventsList.apply {
            adapter = eventsAdapter
            layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
            setHasFixedSize(true)
        }

        viewBinding.newsList.apply {
            adapter = newsAdapter
            layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
            setHasFixedSize(true)
        }

        viewBinding.scheduleList.apply {
            adapter = scheduleAdapter
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
            setHasFixedSize(true)
        }
    }
}