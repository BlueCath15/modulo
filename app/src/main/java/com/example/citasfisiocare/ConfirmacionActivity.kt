package com.example.citasfisiocare

import androidx. appcompat. app. AppCompatActivity

import android. os. Bundle
import android. widget. LinearLayout
import android. widget. TextView


class ConfirmacionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.confirmacion_cita)

        val contenedor = findViewById<LinearLayout>(R.id.contenedor_cardview)
        val inflater = layoutInflater
        val cardView = inflater.inflate(R.layout.citas_registro, contenedor, false)

        val textFecha = cardView.findViewById<TextView>(R.id.tv_fecha)
        val textHora = cardView.findViewById<TextView>(R.id.tv_hora)
        val textEspecialidad = cardView.findViewById<TextView>(R.id.tv_especialidad)
        val textModalidad = cardView.findViewById<TextView>(R.id.tv_modalidad)

        val fecha = intent.getStringExtra("fecha") ?: "Sin fecha"
        val hora = intent.getStringExtra("hora") ?: "Sin hora"
        val especialidad = intent.getStringExtra("especialidad") ?: "Sin especialidad"
        val modalidad = intent.getStringExtra("modalidad") ?: "Sin modalidad"

        textFecha.text = fecha
        textHora.text = hora
        textEspecialidad.text = especialidad
        textModalidad.text = modalidad

        contenedor.addView(cardView)
    }
}

