package com.example.one_team_coding_challenge.model.dto

import com.example.one_team_coding_challenge.model.entity.LevelEntity

data class LevelDTO(
    val state: String,
    val title: String,
    val description: String,
    val activities: List<ActivityDTO>
) {
    companion object {
        fun LevelDTO.toEntity(): LevelEntity {
            return with(this) {
                LevelEntity(
                    title = title,
                    description = description,
                    state = state
                )
            }
        }
    }
}
