package com.nexo.personal.nexo_personal.domain.models

data class Cuenta(
    val idCuenta: Int = 0,
    val saldo: Double = 0.0,
    val presupuesto: Double? = null,
    val privacidadSaldo: Boolean = true, // Boolean para que no falle el Mock
    val idUsuario: Int = 0
)