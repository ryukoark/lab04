package com.example.lab04

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
            title = {
                Text(
                    text = "Diálogo Estilizado",
                    style = MaterialTheme.typography.headlineLarge, // Estilo de título personalizado
                    color = MaterialTheme.colorScheme.primary // Color primario
                )
            },
            text = {
                Text(
                    "Este es el contenido estilizado del diálogo.",
                    style = MaterialTheme.typography.bodyLarge, // Estilo de texto
                    color = MaterialTheme.colorScheme.onBackground // Color de fondo del contenido
                )
            },
            confirmButton = {
                Button(
                    onClick = onConfirm,
                    colors = ButtonDefaults.buttonColors(
                        Color(0xFF4CAF50), Color.White // Verde personalizado
                        // Color de texto del botón
                    ),
                    modifier = Modifier.padding(8.dp) // Espaciado entre botones
                ) {
                    Text("Aceptar")
                }
            },
            dismissButton = {
                Button(
                    onClick = onDismiss,
                    colors = ButtonDefaults.buttonColors(
                        Color(0xFFF44336), Color.White // Rojo personalizado
                    ),
                    modifier = Modifier.padding(8.dp) // Espaciado entre botones
                ) {
                    Text("Cancelar")
                }
            },
            shape = RoundedCornerShape(16.dp) // Esquinas redondeadas del diálogo
        )
    }
}

@Composable
fun DialogScreen() {
    var showDialog by remember { mutableStateOf(false) }

    // Botón para mostrar el diálogo
    Button(
        onClick = { showDialog = true },
        modifier = Modifier.padding(16.dp), // Padding alrededor del botón
        colors = ButtonDefaults.buttonColors(
            Color(0xFF3F51B5), Color.White // Color azul personalizado
        )
    ) {
        Text(text = "Mostrar Diálogo")
    }

    // Llamamos al composable MyDialog
    MyDialog(
        showDialog = showDialog,
        onDismiss = { showDialog = false },
        onConfirm = { showDialog = false }
    )
}
@Composable
fun LazyVerticalGrid(){
    androidx.compose.foundation.lazy.grid.LazyVerticalGrid(
        columns = GridCells.Fixed(3)
    ) {
        items(9) { index ->
            Text(text = "Item #$index")
        }
    }
}
@Composable
fun MySwitch(checked: Boolean, onCheckedChange: (Boolean) -> Unit) {
    Switch(
        checked = checked,
        onCheckedChange = onCheckedChange
    )
}
@Composable
fun SwitchScren() {
    // Estado para controlar si el switch está activado o desactivado
    var isChecked by remember { mutableStateOf(false) }

    // Llamamos al composable MySwitch
    MySwitch(
        checked = isChecked,
        onCheckedChange = { newValue ->
            isChecked = newValue
        }
    )
}