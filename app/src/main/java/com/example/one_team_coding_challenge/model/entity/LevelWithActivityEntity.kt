package com.example.one_team_coding_challenge.model.entity

import androidx.room.Embedded
import androidx.room.Relation

data class LevelWithActivityEntity(
    @Embedded
    val level: LevelEntity,
    @Relation(
        parentColumn = "levelId",
        entityColumn = "levelId"
    )
    val activities: List<ActivityEntity>
)
