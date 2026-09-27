package pe.cibertec.demo.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pe.cibertec.demo.R
import pe.cibertec.demo.ui.model.Producto
import pe.cibertec.demo.ui.theme.CibertecdemoTheme
import pe.cibertec.demo.ui.theme.Dimensions

@Composable
fun ProductoItem(
    producto: Producto,
    onCheckedChange: (Boolean) -> Unit,
    onClick: () -> Unit,
) {
    Row(
        modifier = Modifier.fillMaxWidth()
            // espaciado dinámico con valores reutilizables de Dimensions
            .padding(Dimensions.itemSpacing)
            .clickable{
                onClick()
            }
            .background(colorResource(R.color.blanco)),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            modifier = Modifier.weight(1f),
            text = producto.nombre,
        )
        // llamado de función reutilizable de data class de producto
        Text(
            modifier = Modifier.weight(1f),
            text = "S/ ${producto.subtotal()}",
        )
        Checkbox(
            checked = producto.comprado,
            onCheckedChange = onCheckedChange
        )
    }
}

@Preview
@Composable
fun ProductoItemPreview() {
    CibertecdemoTheme() {
        ProductoItem(
            producto = Producto(
                nombre = "Nombre",
                precio = 2.5,
                cantidad = 2,
                categoria = "categoria",
                estado = "Pendiente",
                comprado = false,
            ),
            onCheckedChange = {},
            onClick = {}
        )
    }
}