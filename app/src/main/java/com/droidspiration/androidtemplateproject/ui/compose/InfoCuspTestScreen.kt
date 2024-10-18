package com.droidspiration.androidtemplateproject.ui.compose

import android.app.DatePickerDialog
import android.widget.DatePicker
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.droidspiration.androidtemplateproject.ui.theme.AndroidTemplateProjectTheme
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

@Composable
fun InfoCuspTestScreen(
    modifier: Modifier = Modifier
) {
    var selectedDate by remember { mutableStateOf("") }
    var selectedDateInfo by remember { mutableStateOf("") }
    var isDateSelected by remember { mutableStateOf(false) }
    val context = LocalContext.current
    val calendar = Calendar.getInstance()

    // Get the current month and year
    val currentCalendar = Calendar.getInstance()
    val currentMonth = currentCalendar.get(Calendar.MONTH)
    val currentYear = currentCalendar.get(Calendar.YEAR)

    val datePickerDialog = DatePickerDialog(
        context,
        { _: DatePicker, year: Int, month: Int, dayOfMonth: Int ->
            // Set the selected date to the state
            calendar.set(year, month, dayOfMonth)
            val format = SimpleDateFormat("dd MMM yyyy", Locale.getDefault())
            selectedDate = format.format(calendar.time)
            isDateSelected = true
            val monthFormat = SimpleDateFormat("MMMM", Locale.getDefault()) // "MMMM" for full month name

            selectedDateInfo = when {
                year == currentYear && month == currentMonth -> {
                    "current month"
                }
                year == currentYear && month == currentMonth - 1 -> {
                    "previous month"
                }
                year == currentYear && month == currentMonth + 1 -> {
                    "next month"
                }
                // Handle year boundary (December -> January)
                year == currentYear - 1 && month == Calendar.DECEMBER && currentMonth == Calendar.JANUARY -> {
                    "previous month"
                }
                year == currentYear + 1 && month == Calendar.JANUARY && currentMonth == Calendar.DECEMBER -> {
                    "next month"
                }
                else -> {
                    monthFormat.format(calendar.time)
                }
            }
        },
        calendar.get(Calendar.YEAR),
        calendar.get(Calendar.MONTH),
        calendar.get(Calendar.DAY_OF_MONTH)
    )

    Box(
        modifier = Modifier
            .fillMaxSize()              // Fill the whole screen
            .padding(top = 42.dp),       // Add top margin of 42dp
        contentAlignment = Alignment.TopCenter // Align content at the center horizontally but top vertically
    ) {
        Column {
            // Button to show the DatePicker
            Button(onClick = {
                datePickerDialog.show()
            }) {
                Text(text = "Select Date")
            }

            Spacer(modifier = Modifier.height(16.dp))

            if (isDateSelected) {
                Text(text = if (selectedDate.isNotEmpty()) "Selected Date: $selectedDate" else "No date selected")

                Text(
                    text = "Selected date is from $selectedDateInfo",
                    modifier = modifier
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AndroidTemplateProjectTheme {
        InfoCuspTestScreen()
    }
}