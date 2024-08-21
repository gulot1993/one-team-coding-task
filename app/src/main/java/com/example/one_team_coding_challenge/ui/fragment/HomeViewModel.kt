package com.example.one_team_coding_challenge.ui.fragment

import android.content.res.AssetManager
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.one_team_coding_challenge.model.domain.LevelWithActivities
import com.example.one_team_coding_challenge.model.entity.ActivityEntity.Companion.toDomain
import com.example.one_team_coding_challenge.model.entity.LevelEntity.Companion.toDomain
import com.example.one_team_coding_challenge.repository.TemperRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(): ViewModel() {

    private val _levelWithActivities = MutableSharedFlow<LevelWithActivities>()
    val levelWithActivities = _levelWithActivities.asSharedFlow()
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
                it.map {
                    val level = it.level.toDomain(it.activities)
                    val activities = it.activities.map { it.toDomain(isLocked = level.state == "LOCKED") }
                    _levelWithActivities.emit(LevelWithActivities(level = level, activities = activities))
                }
            }
            .launchIn(viewModelScope)
    }
}