package com.example.boljistudij.features.news.view

import com.example.boljistudij.features.home.model.NewsModel

data class NewsUIState(
    val listNews: List<NewsModel>,
    val isLoading: Boolean,
)