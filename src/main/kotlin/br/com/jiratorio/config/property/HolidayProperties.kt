package br.com.jiratorio.config.property

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties(prefix = "holiday")
data class HolidayProperties(

    val url: String,

    val token: String

)
