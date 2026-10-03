package pe.cibertec.demo.ui.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun SectionHeader(
    titulo: String,
    modifier: Modifier = Modifier,
) {
    Text(
        text = titulo,
        modifier = modifier,
        style = MaterialTheme.typography.headlineSmall,
    )
}