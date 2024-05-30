package com.example.batalla_gallos.model
import com.fasterxml.jackson.annotation.JsonTypeInfo
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class Cliente (
    val name: String,
    val urlPFP: String,
    val puntuacion: Int
)
