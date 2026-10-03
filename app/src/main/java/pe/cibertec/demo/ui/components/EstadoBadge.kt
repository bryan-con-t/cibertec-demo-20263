package pe.cibertec.demo.ui.components

import androidx.compose.material3.Badge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import pe.cibertec.demo.ui.theme.Accent
import pe.cibertec.demo.ui.theme.Black
import pe.cibertec.demo.ui.theme.CibertecdemoTheme
import pe.cibertec.demo.ui.theme.Primary
import pe.cibertec.demo.ui.theme.White

@Composable
fun EstadoBadge(
    comprado: Boolean
) {
    Badge(
        containerColor = if (comprado) {
            Primary
        } else {
            Accent
        },
        contentColor = if (comprado) {
            White
        } else {
            Black
        }
    ) {
        Text(
            text = if (comprado) {
                "COMPRADO"
            } else {
                "PENDIENTE"
            }
        )
    }
}

@Preview
@Composable
fun EstadoBadgePreview() {
    CibertecdemoTheme {
        EstadoBadge(
            comprado = true
        )
    }
}
