package com.example.front.dashboard.service.consumer

import com.example.front.dashboard.service.consumer.model.CoronaData
import com.fasterxml.jackson.module.kotlin.*
import org.slf4j.LoggerFactory
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Service

// inform.corona에 대한 consumer
@Service
class InformSendConsumer {
    private val objectMapper = jacksonObjectMapper()

    // queue에 발행된 데이터를 기준으로 이메일 발송
    @RabbitListener(queues = ["q.inform.corona.work"])
    fun listenInform(message: String?) {
        log.info(message)
        val coronaData : CoronaData  = objectMapper.readValue(message!!)
        log.info("email send coronaData is {}", coronaData)
    }

    // queue가 정상 소비가 되지않아 dead로 넘어간 큐에 대해서도 모니티링을 통해 처리해줘야한다.
    @RabbitListener(queues = ["q.inform.corona.dead"])
    fun listenInformDead(message: String?) {
        log.info(message)
        val coronaData : CoronaData  = objectMapper.readValue(message!!)
        log.error("dead queue coronaData is {}", coronaData)
    }

    companion object {
        private val log = LoggerFactory.getLogger(InformSendConsumer::class.java)
    }
}