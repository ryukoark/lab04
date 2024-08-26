package com.example.lab04

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.lab04.ui.theme.Lab04Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DialogScreen()
        }
    }
}

@Composable
fun MyDialog(showDialog: Boolean, onDismiss: () -> Unit, onConfirm: () -> Unit) {
    if (showDialog) {
        AlertDialog(
            onDismissRequest = onDismiss,
            title = { Text(text = "Dialogo Simple") },
            text = { Text("Este es el contenido del diálogo.") },
            confirmButton = {
                Button(onClick = onConfirm) { Text("Aceptar") }
            },
            dismissButton = {
                Button(onClick = onDismiss) { Text("Cancelar") }
            }
        )
    }
}
@Composable
fun DialogScreen() {
    // Estado para controlar si el diálogo está visible
    var showDialog by remember { mutableStateOf(false) }

    // Botón para mostrar el diálogo
    Button(onClick = { showDialog = true }) {
        Text(text = "Mostrar Diálogo")
    }

    // Llamamos al composable MyDialog
    MyDialog(
        showDialog = showDialog,
        onDismiss = { showDialog = false },
        onConfirm = {
            // Acción al confirmar
            showDialog = false
        }
    )
}
