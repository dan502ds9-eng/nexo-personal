package com.nexo.personal.nexo_personal.domain.models

data class Transaccion(
    val idTransaccion: Int = 0,
    val tipo: String, // 'INGRESO' o 'GASTO'
    val monto: Double,
    val fecha: String? = null,
    val concepto: String? = null,
    val idCuenta: Int
)
