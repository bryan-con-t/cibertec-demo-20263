package pe.cibertec.demo.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import pe.cibertec.demo.ui.model.Producto
import pe.cibertec.demo.ui.model.productosDemo
import pe.cibertec.demo.ui.theme.CibertecdemoTheme
import pe.cibertec.demo.ui.theme.Danger
import pe.cibertec.demo.ui.theme.Dimensions
import pe.cibertec.demo.ui.theme.Gray
import pe.cibertec.demo.ui.theme.Primary
import pe.cibertec.demo.ui.theme.Secondary
import pe.cibertec.demo.ui.theme.Tertiary
import pe.cibertec.demo.ui.theme.White

@Composable
fun ProductoCard(
    producto: Producto,
    onCompradoChange: (Boolean) -> Unit,
    onClick: () -> Unit,
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        onClick = onClick,
        shape = RoundedCornerShape(Dimensions.cardRadius),
        colors = CardDefaults.cardColors(
            containerColor = White
        )
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
                .padding(Dimensions.cardPadding),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(Dimensions.itemSpacing),
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = producto.nombre,
                    style = MaterialTheme.typography.titleMedium,
                    color = Primary,
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(Dimensions.itemSpacing)
                ) {
                    Text(
                        text = producto.categoria,
                        style = MaterialTheme.typography.bodyMedium,
                        color = Secondary,
                    )
                    EstadoBadge(producto.comprado)
                }
                Text(
                    text = "S/ ${producto.precio} • Cant.: ${producto.cantidad}",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Tertiary,
                )
            }
            Switch(
                checked = producto.comprado,
                onCheckedChange = onCompradoChange,
            )
        }
    }
}

@Preview
@Composable
fun ProductoCardPreview() {
    CibertecdemoTheme {
        ProductoCard(
            producto = productosDemo[1],
            onClick = {

            },
            onCompradoChange = {

            }
        )
    }
}