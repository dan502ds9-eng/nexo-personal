package com.nexo.personal.nexo_personal.domain.models

data class Meta(
    val idMeta: Int = 0,
    val nombreMeta: String,
    val montoObjetivo: Double,
    val montoActual: Double = 0.0,
    val fechaLimite: String? = null,
    val idUsuario: Int
)
