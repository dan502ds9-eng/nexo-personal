package com.nexo.personal.nexo_personal

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.nexo.personal.nexo_personal.ui.theme.NexoTheme
import org.jetbrains.compose.resources.painterResource
// Estas líneas se curarán solas cuando el nombre del archivo esté bien
import nexo_personal.composeapp.generated.resources.Res
import nexo_personal.composeapp.generated.resources.zorro_nexo

@Composable
fun App() {
    var nombre by remember { mutableStateOf("") }
    var pin by remember { mutableStateOf("") }
    var registrado by remember { mutableStateOf(false) }

    NexoTheme {
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
            Column(
                modifier = Modifier.fillMaxSize().padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                // 🦊 TU ZORRITO FUTURISTA
                Image(
                    painter = painterResource(Res.drawable.zorro_nexo),
                    contentDescription = "Mascota Nexo",
                    modifier = Modifier.size(220.dp)
                )

                Spacer(modifier = Modifier.height(20.dp))

                if (!registrado) {
                    Text("REGISTRO NEXO", style = MaterialTheme.typography.headlineMedium, color = MaterialTheme.colorScheme.primary)

                    Spacer(modifier = Modifier.height(16.dp))

                    OutlinedTextField(
                        value = nombre,
                        onValueChange = { nombre = it },
                        label = { Text("Nombre de Usuario") },
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    OutlinedTextField(
                        value = pin,
                        onValueChange = { if (it.length <= 4) pin = it },
                        label = { Text("PIN (4 dígitos)") },
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    Button(
                        onClick = { if(nombre.isNotEmpty() && pin.length == 4) registrado = true },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("REGISTRARME")
                    }
                } else {
                    Text("¡Bienvenido, $nombre!", style = MaterialTheme.typography.headlineSmall, color = MaterialTheme.colorScheme.secondary)
                }
            }
        }
    }
}