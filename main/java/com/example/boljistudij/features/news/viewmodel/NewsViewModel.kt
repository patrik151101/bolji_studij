package com.example.boljistudij.features.news.viewmodel

import androidx.lifecycle.ViewModel
import com.example.boljistudij.features.home.model.NewsModel
import com.example.boljistudij.features.news.view.NewsUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor() : ViewModel() {
    val uiStateFlow = MutableStateFlow(
        NewsUIState(
            isLoading = false,
            listNews = listOf(
                NewsModel(
                    title = "Konacni rezultati",
                    author = "doc.dr.sc.Davor Cafuta",
                    profileImage = "https://www.tvz.hr/wp-content/uploads/2021/12/Davor-Cafuta.png",
                    news = "Objavljeni su rezultati nakon ponavljanja završnog ispita.\n" +
                            "\n" +
                            "Predložene ocjene dobivene završnim ispitom biti će upisane na prvom roku 25.06. Ne morate ga prijavljivati.\n" +
                            "Možete se javiti do datuma roka ako želite podići ocjenu kroz usmeni ispit ili ako želite odbiti ocjenu emailom nositelju kolegija.\n" +
                            "\n" +
                            "Svaki slijedeći rok morate prijavljivati u ISVU. Bez prijave u ISVU ne možete pristupiti roku.",
                    publishedDate = "Objavljeno: 21.06.2022 u 9h"
                ),
                NewsModel(
                    title = "Konacni rezultati",
                    author = "doc.dr.sc.Davor Cafuta",
                    profileImage = "https://www.tvz.hr/wp-content/uploads/2021/12/Davor-Cafuta.png",
                    news = "Objavljeni su rezultati nakon ponavljanja završnog ispita.\n" +
                            "\n" +
                            "Predložene ocjene dobivene završnim ispitom biti će upisane na prvom roku 25.06. Ne morate ga prijavljivati.\n" +
                            "Možete se javiti do datuma roka ako želite podići ocjenu kroz usmeni ispit ili ako želite odbiti ocjenu emailom nositelju kolegija.\n" +
                            "\n" +
                            "Svaki slijedeći rok morate prijavljivati u ISVU. Bez prijave u ISVU ne možete pristupiti roku.",
                    publishedDate = "Objavljeno: 21.06.2022 u 9h"
                )
            ),
        )
    )
}