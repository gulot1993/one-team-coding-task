package com.example.one_team_coding_challenge.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ActivityEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String = "",
    val description: String = "",
    val lockedIconUrl: String = "",
    val iconUrl: String = ""
)
