package com.nexo.personal.nexo_personal.domain.models

data class Usuario(
    val idUsuario: Int = 0,
    val nombre: String,
    val correo: String,
    val pinAcceso: String
)
