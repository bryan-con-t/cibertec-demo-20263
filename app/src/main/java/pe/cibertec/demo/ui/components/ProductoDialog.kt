package pe.cibertec.demo.ui.components

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import pe.cibertec.demo.ui.model.Producto

@Composable
fun ProductoDialog(
    producto: Producto,
    onDismiss: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Text(
                text = "Producto seleccionado",
            )
        },
        text = {
            Text(
                text = producto.nombre,
            )
        },
        confirmButton = {
            TextButton(
                onClick = onDismiss
            ) {
                Text(
                    text = "Aceptar"
                )
            }
        }
    )
}
