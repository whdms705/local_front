package com.example.front.dashboard.service.consumer.model

import com.example.front.dashboard.common.json.CustomLocalDateDeserializer
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import lombok.Getter
import lombok.Setter
import java.time.LocalDate

data class CoronaData(
        @JsonProperty("new_case")
        private val newCase: Int = 0,
        @JsonProperty("station_name")
        private val stationName: String? = null,
        private val email: String? = null,

        @JsonProperty("create_date")
        @JsonDeserialize(using = CustomLocalDateDeserializer::class)
        private val createDate: LocalDate? = null
)