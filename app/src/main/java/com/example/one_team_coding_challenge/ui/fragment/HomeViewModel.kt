package com.example.one_team_coding_challenge.ui.fragment

import androidx.lifecycle.ViewModel
import com.example.one_team_coding_challenge.repository.TemperRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(): ViewModel() {
    @Inject
    lateinit var temperRepository: TemperRepository
}