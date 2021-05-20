package com.iot.data.service

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Profile
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Profile("kafka")
@Service
class KafkaWriter(
    @Value("\${app.topic}")
    private val topic: String,
    private val dataConsumer: DataConsumer,
    private val kafkaTemplate: KafkaTemplate<String, String>
) : Strategy {

    fun sendMessage(msg: String?) {
        kafkaTemplate.send(topic, msg)
    }

    @KafkaListener(topics = ["\${app.topic}"], groupId = "\${spring.kafka.groupId}")
    fun listen(message: String): String {
        println("Received Message in group - group-id: $message")

        return message
    }

    override fun run(vararg args: String?) {
        dataConsumer.fetchData().doOnNext {
            println("Sending data to topic id = ${it.year}")
            sendMessage(it.toString())
        }
            .subscribe()
    }
}
