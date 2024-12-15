package com.mikeapp.newideatodoapp.map

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun DiameterPickerDialog(
    onDismiss: () -> Unit,
    onDistanceSelected: (Double) -> Unit
) {
    val distances = listOf(30.0, 50.0, 100.0, 200.0, 1000.0)
    var customDiameter by remember { mutableStateOf("") }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Select Diameter") },
        text = {
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                // List of predefined distances
                distances.forEach { diameter ->
                    TextButton(
                        modifier = Modifier.fillMaxWidth(),
                        onClick = { onDistanceSelected(diameter) }) {
                        Text("$diameter meters")
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Custom distance input
                Text("Or enter a custom distance:")
                TextField(
                    value = customDiameter,
                    onValueChange = { customDiameter = it },
                    label = { Text("Custom distance") },
                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
                )
            }
        },
        confirmButton = {
            Button(onClick = {
                if (customDiameter.isNotEmpty()) {
                    onDistanceSelected(customDiameter.toDoubleOrNull() ?: 200.0)
                }
                onDismiss()
            }) {
                Text("OK")
            }
        },
        dismissButton = {
            Button(onClick = onDismiss) {
                Text("Cancel")
            }
        }
    )
}