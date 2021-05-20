package com.iot.data.service

import com.iot.data.service.dto.ShootingIncidentDataDto
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Flux

@Service
class DataConsumer(
    private val webClient: WebClient
) {

    @Value("\${app.shooting.incident.url}")
    lateinit var dataUrl: String

    private val log: Logger = LoggerFactory.getLogger(this::class.java)

    fun fetchData(): Flux<ShootingIncidentDataDto> {
        log.info("Fetching data from URL - $dataUrl")

        return webClient.get()
            .uri(dataUrl)
            .retrieve()
            .bodyToFlux(ShootingIncidentDataDto::class.java)
    }
}
