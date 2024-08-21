package com.example.one_team_coding_challenge.model.domain

data class Level(
    val title: String,
    val titleB: String,
    val description: String,
    val descriptionB: String,
    val activities: List<Activity>
)
