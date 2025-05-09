package com.example.citasfisiocare


import android.app.DatePickerDialog
import android.content.Context
import android.widget.TextView
import java.util.*

object DatePickerUtil {
    fun showDatePicker(context: Context, targetView: TextView) {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            context,
            { _, selectedYear, selectedMonth, selectedDay ->
                val formattedDate = String.format("%02d/%02d/%02d", selectedDay, selectedMonth + 1, selectedYear % 100)
                targetView.text = formattedDate
            },
            year, month, day
        )

        datePickerDialog.show()
    }
}
