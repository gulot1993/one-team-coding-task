package com.example.one_team_coding_challenge.model.dto

data class LevelDTO(
    val title: String,
    val titleB: String,
    val description: String,
    val descriptionB: String,
    val activities: List<ActivityDTO>
)
