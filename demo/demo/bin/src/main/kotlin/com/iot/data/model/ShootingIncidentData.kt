package com.iot.data.model

import java.time.LocalDateTime

data class ShootingIncidentData(
    val id: String,
    val date: LocalDateTime,
    val sex: String,
    val race: String,
    val location: String,
    val jurisdiction: String
)
