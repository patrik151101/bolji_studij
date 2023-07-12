package com.example.boljistudij.features.home.view

import com.example.boljistudij.features.home.model.EventModel
import com.example.boljistudij.features.home.model.NewsModel
import com.example.boljistudij.features.home.model.ScheduleModel

data class HomeUIState(
    val listEvent: List<EventModel>,
    val listNews: List<NewsModel>,
    val listSchedule: List<ScheduleModel>,
    val isLoading: Boolean,
)