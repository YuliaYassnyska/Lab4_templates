package com.iot.data.service.dto

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDateTime

data class ShootingIncidentDataDto(
    @JsonProperty("incident_key")
    val id: String? = null,
    @JsonProperty("occur_date")
    val date: LocalDateTime? = null,
    @JsonProperty("vic_sex")
    val sex: String? = null,
    @JsonProperty("vic_race")
    val race: String? = null,
    @JsonProperty("location_desc")
    val location: String? = null,
    @JsonProperty("jurisdiction_code")
    val jurisdiction: String? = null
)
