package com.example.one_team_coding_challenge.model.domain

data class Activity(
    val type: String,
    val description: String,
    val state: String,
    val icon: Icon,
    val lockedIcon: Icon
)
