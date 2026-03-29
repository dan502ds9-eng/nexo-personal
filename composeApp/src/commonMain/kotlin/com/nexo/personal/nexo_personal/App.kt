package com.nexo.personal.nexo_personal

import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nexo.personal.nexo_personal.ui.theme.NexoTheme
import org.jetbrains.compose.resources.painterResource

// 1. REVISA ESTOS IMPORTS (Asegúrate que coincidan con tu paquete)
import nexo_personal.composeapp.generated.resources.Res
import nexo_personal.composeapp.generated.resources.zorro

@Composable
fun App() {
    // ESTADOS DE REGISTRO (Raíz de NEXO)
    var nombre by remember { mutableStateOf("") }
    var pin by remember { mutableStateOf("") }
    var registrado by remember { mutableStateOf(false) }

    // --- ANIMACIÓN DE FONDO (EFECTO CYBERPUNK) ---
    val infiniteTransition = rememberInfiniteTransition()
    val gridOffset by infiniteTransition.animateFloat(
        initialValue = 0f, targetValue = 1f,
        animationSpec = infiniteRepeatable(animation = tween(5000, easing = LinearEasing))
    )

    NexoTheme {
        Box(modifier = Modifier.fillMaxSize().background(Color(0xFF010103))) {

            // 🎨 CANVAs: REJILLA NEÓN DINÁMICA
            Canvas(modifier = Modifier.fillMaxSize()) {
                val gridSize = 140f
                val offsetPx = gridOffset * gridSize
                for (y in 0 until (size.height / gridSize).toInt() + 1) {
                    val yPos = (y * gridSize + offsetPx) % size.height
                    drawLine(
                        color = Color(0xFF00FFFF).copy(alpha = 0.08f),
                        start = Offset(0f, yPos),
                        end = Offset(size.width, yPos),
                        strokeWidth = 2f
                    )
                }
            }

            // 📱 CONTENIDO DE LA APP
            Column(
                modifier = Modifier.fillMaxSize().padding(horizontal = 30.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                // --- EL GIF DEL ZORRO ---
                Image(
                    painter = painterResource(Res.drawable.zorro),
                    contentDescription = "Mascota Nexo",
                    modifier = Modifier.size(280.dp)
                )

                if (!registrado) {
                    Text(
                        text = "NEXO CORE",
                        style = TextStyle(
                            fontSize = 42.sp,
                            fontWeight = FontWeight.Black,
                            color = Color.White,
                            shadow = Shadow(color = Color(0xFF00FFFF), blurRadius = 25f)
                        )
                    )

                    Spacer(modifier = Modifier.height(30.dp))

                    // INPUT USUARIO
                    OutlinedTextField(
                        value = nombre,
                        onValueChange = { nombre = it },
                        label = { Text("USUARIO_ID", color = Color.Cyan.copy(0.5f)) },
                        modifier = Modifier.fillMaxWidth(),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Color.Cyan,
                            unfocusedBorderColor = Color.DarkGray,
                            focusedTextColor = Color.White
                        )
                    )

                    Spacer(modifier = Modifier.height(15.dp))

                    // INPUT PIN
                    OutlinedTextField(
                        value = pin,
                        onValueChange = { if (it.length <= 4) pin = it },
                        label = { Text("PASS_CODE", color = Color.Magenta.copy(0.5f)) },
                        modifier = Modifier.fillMaxWidth(),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Color.Magenta,
                            unfocusedBorderColor = Color.DarkGray,
                            focusedTextColor = Color.White
                        )
                    )

                    Spacer(modifier = Modifier.height(35.dp))

                    // BOTÓN DE ACCESO
                    Button(
                        onClick = {
                            if(nombre.isNotEmpty() && pin.length == 4) {
                                registrado = true
                            }
                        },
                        modifier = Modifier.fillMaxWidth().height(60.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF00FFFF))
                    ) {
                        Text("VINCULAR SISTEMA", color = Color.Black, fontWeight = FontWeight.Bold)
                    }

                } else {
                    // PANTALLA POST-REGISTRO
                    Text("NODO ACTIVO", color = Color.Green, fontWeight = FontWeight.Bold)
                    Text("BIENVENIDO, $nombre", color = Color.White, fontSize = 28.sp)
                }
            }
        }
    }
}