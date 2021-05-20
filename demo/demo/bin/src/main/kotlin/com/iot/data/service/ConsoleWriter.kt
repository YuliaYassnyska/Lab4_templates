package com.iot.data.service

import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Service

@Profile("console")
@Service
class ConsoleWriter(
    private val dataConsumer: DataConsumer
) : Strategy {
    override fun run(vararg args: String?) {
        dataConsumer.fetchData().doOnNext { println("Writing to console - $it") }.subscribe()
    }
}
