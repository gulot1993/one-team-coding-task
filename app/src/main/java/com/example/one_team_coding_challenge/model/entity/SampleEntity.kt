package com.example.one_team_coding_challenge.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class SampleEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int
)
