package com.example.one_team_coding_challenge.model.dto

import com.example.one_team_coding_challenge.model.entity.ActivityEntity

data class ActivityDTO(
    val type: String,
    val description: String,
    val state: String,
    val icon: IconDTO,
    val lockedIcon: IconDTO,
    val title: String
) {
    companion object {
        fun ActivityDTO.toEntity(): ActivityEntity {
            return with(this) {
                 ActivityEntity(
                     title = title,
                     description = description,
                     lockedIconUrl = lockedIcon.fileDTO.url,
                     iconUrl = icon.fileDTO.url
                 )
            }
        }
    }
}
