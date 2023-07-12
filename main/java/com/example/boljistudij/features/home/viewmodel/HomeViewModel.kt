package com.example.boljistudij.features.home.viewmodel

import androidx.lifecycle.ViewModel
import com.example.boljistudij.features.home.model.EventModel
import com.example.boljistudij.features.home.model.NewsModel
import com.example.boljistudij.features.home.model.ScheduleModel
import com.example.boljistudij.features.home.view.HomeUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {

    val uiStateFlow = MutableStateFlow(
        HomeUIState(
            listEvent = listOf(
                EventModel(
                    title = "Tehnički muzej studentska izložba",
                    date = "24.6.2023.",
                    url = "https://www.tvz.hr/wp-content/uploads/2021/12/702A4193-1.png",
                ),
                EventModel(
                    title = "TVZ Karijer dan",
                    date = "25.5.2023.",
                    url = "https://www.tvz.hr/wp-content/uploads/2023/05/IMG-0f8ef7ee0e8e4e1364833d7dcccc7f27-V.jpg",
                ),
                EventModel(
                    title = "Posjet Graditelja",
                    date = "24.6.2023.",
                    url = "https://www.tvz.hr/wp-content/uploads/2023/06/image.png",
                ),
                EventModel(
                    title = "Infobip radionica",
                    date = "20.4.2023.",
                    url = "https://www.tvz.hr/wp-content/uploads/2023/05/photo2-scaled.jpg",
                ),
            ),
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
            listSchedule = listOf(
                ScheduleModel(
                    day = "28.",
                    month = "lipnja",
                    time = "08:00 - 09:30",
                    isCourse = true,
                    course = "UVOD U UNIX - predavanje",
                    fullName = "Davor Cafuta",
                    profileImage = "https://www.tvz.hr/wp-content/uploads/2021/12/Davor-Cafuta.png"
                ),
                ScheduleModel(
                    day = "30.",
                    month = "lipnja",
                    time = "09:00 - 10:30",
                    isCourse = true,
                    course = "MATEMATIKA - predavanje",
                    fullName = "Lidija Tepeš Golubić",
                    profileImage = "https://www.tvz.hr/wp-content/uploads/2021/12/Lidija-Tepes.png"
                ),
                ScheduleModel(
                    day = "31.",
                    month = "lipnja",
                    time = "14:00 - 15:30",
                    isCourse = false,
                    course = "UVOD U UNIX - vježbe",
                    fullName = "Davor Cafuta",
                    profileImage = "https://www.tvz.hr/wp-content/uploads/2021/12/Davor-Cafuta.png"
                )
            )
        )
    )
}