package com.example.one_team_coding_challenge.repository

import com.example.one_team_coding_challenge.model.domain.Levels

interface TemperRepository {
    suspend fun getTempers(): List<Levels>
}