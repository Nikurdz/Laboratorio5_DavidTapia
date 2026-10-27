package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // Configuración Edge-to-Edge requerida
        setContent {
            MaterialTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    LoginScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun LoginScreen(modifier: Modifier = Modifier) {
    // 1. Estado: 'remember' hace que la variable sobreviva a la recomposición
    var username by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        // 2. Construcción de la UI
        OutlinedTextField(
            value = username,
            onValueChange = { username = it }, // Actualiza el estado al escribir
            label = { Text("Nombre de Usuario") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))

        // 3. Lógica declarativa: la UI depende del estado
        val isValid = username.length >= 3
        val message = if (isValid) "Nombre aceptado" else "Nombre muy corto (mín. 3)"
        val color = if (isValid) Color(0xFF2E7D32) else Color.Red // Verde vs Rojo

        Text(
            text = message,
            color = color,
            style = MaterialTheme.typography.bodyMedium
        )
        Spacer(modifier = Modifier.height(16.dp))

        // 4. Desafío extra: el botón se habilita con 5 o más caracteres
        Button(
            onClick = { },
            enabled = username.length >= 5,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Continuar")
        }
    }
}
