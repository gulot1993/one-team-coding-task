package com.example.one_team_coding_challenge.repository

import android.content.res.Resources
import com.example.one_team_coding_challenge.R
import com.example.one_team_coding_challenge.database.AppDatabase
import com.example.one_team_coding_challenge.model.domain.Levels
import com.example.one_team_coding_challenge.model.dto.ActivityDTO.Companion.toEntity
import com.example.one_team_coding_challenge.model.dto.LevelDTO.Companion.toEntity
import com.example.one_team_coding_challenge.model.dto.LevelsDTO
import com.example.one_team_coding_challenge.model.entity.LevelWithActivityEntity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TemperRepositoryImpl @Inject constructor(): TemperRepository {
    @Inject
    lateinit var resources: Resources

    @Inject
    lateinit var database: AppDatabase

    override suspend fun saveAndLoadTemperLevels() {
        val gson = Gson()
        val levels = resources
            .openRawResource(R.raw.api)
            .bufferedReader()
            .use {
                gson.fromJson<LevelsDTO>(it, object : TypeToken<LevelsDTO>() {}.type)
            }
            .levels
        levels
            .map {
                val level = it.toEntity()
                database.temperDao().addLevelWithActivities(
                    level = level,
                    activities = it.activities.map { it.toEntity() }
                )
            }
    }

    override fun loadLevelWithActivities(): Flow<List<LevelWithActivityEntity>> {
        return database.temperDao().loadLevelWithActivities()
    }
}