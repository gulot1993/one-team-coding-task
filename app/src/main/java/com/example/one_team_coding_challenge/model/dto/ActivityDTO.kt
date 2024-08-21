package com.example.one_team_coding_challenge.model.dto

data class ActivityDTO(
    val type: String,
    val description: String,
    val state: String,
    val icon: IconDTO,
    val lockedIcon: IconDTO
)
