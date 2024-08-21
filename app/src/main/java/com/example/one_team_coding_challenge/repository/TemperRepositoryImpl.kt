package com.example.one_team_coding_challenge.repository

import android.content.res.Resources
import com.example.one_team_coding_challenge.R
import com.example.one_team_coding_challenge.model.domain.Levels
import com.example.one_team_coding_challenge.model.dto.LevelDTO
import com.example.one_team_coding_challenge.model.dto.LevelsDTO
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import timber.log.Timber
import javax.inject.Inject

class TemperRepositoryImpl @Inject constructor(): TemperRepository {
    @Inject
    lateinit var resources: Resources
    override suspend fun getTempers(): List<Levels> {
        val gson = Gson()
        val levelsDTO = resources
            .openRawResource(R.raw.api)
            .bufferedReader()
            .use {
                gson.fromJson<LevelsDTO>(it, object : TypeToken<LevelsDTO>() {}.type)
            }

        return emptyList()
    }
}