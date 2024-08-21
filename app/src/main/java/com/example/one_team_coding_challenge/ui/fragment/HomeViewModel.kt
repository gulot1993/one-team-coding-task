package com.example.one_team_coding_challenge.ui.fragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.one_team_coding_challenge.model.domain.Level
import com.example.one_team_coding_challenge.model.entity.ActivityEntity.Companion.toDomain
import com.example.one_team_coding_challenge.model.entity.LevelEntity.Companion.toDomain
import com.example.one_team_coding_challenge.repository.TemperRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(): ViewModel() {

    private val _levelWithActivities = MutableSharedFlow<List<Level>>()
    val levelWithActivities = _levelWithActivities.asSharedFlow()
    @Inject
    lateinit var temperRepository: TemperRepository

    fun saveAndLoadTemperLevels() {
        viewModelScope.launch {
            clearData()
            temperRepository.saveAndLoadTemperLevels()
            loadTemperLevelsWithActivities()
        }
    }

    private fun loadTemperLevelsWithActivities() {
        temperRepository
            .loadLevelWithActivities()
            .onEach {
                val levels = it.map {
                    val level = it.level.toDomain(it.activities)
                    val activities = it.activities.map { it.toDomain(isLocked = level.state == "LOCKED") }
                    level.activities = activities
                    return@map level
                }
                _levelWithActivities.emit(levels)
            }
            .launchIn(viewModelScope)
    }

    private fun clearData() {
        viewModelScope.launch(Dispatchers.IO) { temperRepository.clearTables() }
    }

    override fun onCleared() {
        super.onCleared()
    }
}