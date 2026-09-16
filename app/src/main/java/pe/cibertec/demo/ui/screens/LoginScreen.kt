package pe.cibertec.demo.ui.screens

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pe.cibertec.demo.R
import pe.cibertec.demo.ui.theme.CibertecdemoTheme

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current

    var email by remember { mutableStateOf("") }
    var clave by remember { mutableStateOf("") }
    var claveVisible by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Icon(
//            modifier = Modifier.width(100.dp),
            painter = painterResource(R.drawable.ic_app),
            contentDescription = null,
        )
        Text(
            text = "Cibertec Demo"
        )
        Text(
            text = "Lista de compras"
        )
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = {
                Text(
                    text = "Correo electrónico"
                )
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email
            ),
            singleLine = true,
            leadingIcon = {
                Icon(
                    painter = painterResource(R.drawable.ic_mail),
                    contentDescription = null,
                )
            }
        )
        OutlinedTextField(
            value = clave,
            onValueChange = { clave = it },
            label = {
                Text(
                    text = "Contraseña"
                )
            },
            visualTransformation = if (claveVisible) {
                VisualTransformation.None
            } else {
                PasswordVisualTransformation()
            },
            trailingIcon = {
                IconButton(
                    onClick = {
                        claveVisible = !claveVisible
                    }
                ) {
                    Icon(
                        painter = if (claveVisible) {
                            painterResource(R.drawable.ic_hide)
                        } else {
                            painterResource(R.drawable.ic_show)
                        },
                        contentDescription = "",
                    )
                }
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            ),
            singleLine = true,
            leadingIcon = {
                Icon(
                    painter = painterResource(R.drawable.ic_lock),
                    contentDescription = null,
                )
            }
        )
        Button(
            onClick = {
                Log.e("CIBERTEC_CLICK", "Mensaje")
                Toast.makeText(context, "Mensaje", Toast.LENGTH_SHORT).show()
            }
        ) {
            Text(
                text = "Iniciar sesión"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    CibertecdemoTheme {
        LoginScreen(
            modifier = Modifier.fillMaxSize()
        )
    }
}
