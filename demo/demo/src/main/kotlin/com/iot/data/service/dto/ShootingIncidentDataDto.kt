package com.iot.data.service.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class ShootingIncidentDataDto(
    @JsonProperty("year")
    val year: String? = null,
    @JsonProperty("leading_cause")
    val leadingСause: String? = null,
    @JsonProperty("sex")
    val sex: String? = null,
    @JsonProperty("race_ethnicity")
    val race: String? = null,
    @JsonProperty("deaths")
    val deaths: String? = null
)
