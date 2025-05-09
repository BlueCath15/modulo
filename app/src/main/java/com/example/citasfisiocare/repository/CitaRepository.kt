package com.example.citasfisiocare.repository
import com. example. citasfisiocare. model. Cita
class CitaRepository {
    private val listaCitas = mutableListOf<Cita>()

    fun agregarCita(cita: Cita) {
        listaCitas.add(cita)
    }

    fun obtenerCitas(): List<Cita> = listaCitas
}
