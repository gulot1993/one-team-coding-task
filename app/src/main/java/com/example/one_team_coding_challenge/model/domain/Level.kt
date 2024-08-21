package com.example.one_team_coding_challenge.model.domain

data class Level(
    val title: String,
    val description: String,
    var activities: List<Activity>,
    val state: String,
    val level: String
)
