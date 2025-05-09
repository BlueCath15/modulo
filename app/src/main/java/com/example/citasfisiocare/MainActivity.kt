package com.example.citasfisiocare


import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java. util. Calendar
import android.app.DatePickerDialog



class MainActivity : AppCompatActivity() {

    private lateinit var tvFechaPicker: TextView
    private lateinit var spinnerHora: Spinner
    private lateinit var spinnerEspecialidad: Spinner
    private lateinit var spinnerModalidad: Spinner
    private lateinit var botonGuardar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.agendamiento_main)

        tvFechaPicker = findViewById(R.id.tv_fecha_picker)
        spinnerHora = findViewById(R.id.spinner_hora)
        spinnerEspecialidad = findViewById(R.id.spinner_especialidad)
        spinnerModalidad = findViewById(R.id.spinner_modalidad)
        botonGuardar = findViewById(R.id.guardar_info)

        // Llenar los Spinners
        val horas = listOf("8:00 AM", "9:00 AM", "10:00 AM")
        val especialidades = listOf("Fisioterapia", "Psicología", "Nutrición")
        val modalidades = listOf("Presencial", "Virtual")

        spinnerHora.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, horas)
        spinnerEspecialidad.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, especialidades)
        spinnerModalidad.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, modalidades)

        // Mostrar DatePicker al tocar el TextView
        tvFechaPicker.setOnClickListener {
            mostrarDatePicker()
        }

        // Guardar datos y lanzar Confirmación
        botonGuardar.setOnClickListener {
            val fechaSeleccionada = tvFechaPicker.text.toString()

            val intent = Intent(this, ConfirmacionActivity::class.java).apply {
                putExtra("fecha", fechaSeleccionada)
                putExtra("hora", spinnerHora.selectedItem.toString())
                putExtra("especialidad", spinnerEspecialidad.selectedItem.toString())
                putExtra("modalidad", spinnerModalidad.selectedItem.toString())
            }
            startActivity(intent)
        }
    }

    private fun mostrarDatePicker() {
        val calendario = Calendar.getInstance()
        val año = calendario.get(Calendar.YEAR)
        val mes = calendario.get(Calendar.MONTH)
        val dia = calendario.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(this, { _, añoSel, mesSel, diaSel ->
            val fechaFormateada = String.format("%02d/%02d/%02d", diaSel, mesSel + 1, añoSel % 100)
            tvFechaPicker.text = fechaFormateada
        }, año, mes, dia)

        datePickerDialog.show()
    }
}
