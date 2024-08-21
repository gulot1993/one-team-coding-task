package com.example.one_team_coding_challenge.repository

import com.example.one_team_coding_challenge.model.domain.Levels
import com.example.one_team_coding_challenge.model.entity.LevelWithActivityEntity
import kotlinx.coroutines.flow.Flow

interface TemperRepository {
    suspend fun saveAndLoadTemperLevels()
    fun loadLevelWithActivities(): Flow<List<LevelWithActivityEntity>>
}