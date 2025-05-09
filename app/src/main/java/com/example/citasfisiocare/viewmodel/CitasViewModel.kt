package com.example.citasfisiocare.viewmodel
import androidx. lifecycle. ViewModel
import androidx. lifecycle. MutableLiveData
import com. example. citasfisiocare. repository. CitaRepository
import com. example. citasfisiocare. model. Cita
import androidx. lifecycle. LiveData

class CitaViewModel : ViewModel() {
    private val repository = CitaRepository()

    private val _citas = MutableLiveData<List<Cita>>()
    val citas: LiveData<List<Cita>> = _citas

    fun agregarCita(cita: Cita) {
        repository.agregarCita(cita)
        _citas.value = repository.obtenerCitas()
    }
}
