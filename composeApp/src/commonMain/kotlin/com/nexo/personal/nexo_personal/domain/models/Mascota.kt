package com.nexo.personal.nexo_personal.domain.models

data class Mascota(
    val idMascota: Int = 0,
    val skinActiva: String = "basica",
    val rachaActiva: Int = 0,
    val idUsuario: Int
)
