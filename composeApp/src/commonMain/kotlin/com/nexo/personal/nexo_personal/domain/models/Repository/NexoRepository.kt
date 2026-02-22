package com.nexo.personal.nexo_personal.domain.Repository

// IMPORT PARA Q SEA EL PUENTE QUE CONECTE Y NO MARQUE ERROR
import com.nexo.personal.nexo_personal.domain.models.*

interface NexoRepository {
    // --- AUTENTICACIÓN DE REGISTRO ---
    fun registrarUsuario(usuario: Usuario): Boolean
    fun iniciarSesion(correo: String, pin: String): Usuario?

    // --- GESTIÓN DE CUENTA Y DINERO ---
    fun obtenerCuenta(idUsuario: Int): Cuenta
    fun registrarTransaccion(transaccion: Transaccion): Boolean
    fun obtenerHistorialTransacciones(idCuenta: Int): List<Transaccion>

    // --- GAMIFICACIÓN Y METAS ---
    fun obtenerMascota(idUsuario: Int): Mascota
    fun actualizarRachaMascota(idMascota: Int, nuevaRacha: Int)
    fun obtenerMetas(idUsuario: Int): List<Meta>
    fun crearMeta(meta: Meta): Boolean
}