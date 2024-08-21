package com.example.one_team_coding_challenge.ui.fragment

import android.content.res.AssetManager
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.one_team_coding_challenge.repository.TemperRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(): ViewModel() {
    @Inject
    lateinit var temperRepository: TemperRepository

    fun saveAndLoadTemperLevels() {
        viewModelScope.launch {
            temperRepository.saveAndLoadTemperLevels()
            loadTemperLevelsWithActivities()
        }
    }

    private fun loadTemperLevelsWithActivities() {
        temperRepository
            .loadLevelWithActivities()
            .onEach {

            }
            .launchIn(viewModelScope)
    }
}