package pe.cibertec.demo.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import pe.cibertec.demo.R
import pe.cibertec.demo.ui.components.SectionHeader

@Composable
fun PerfilScreen(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        SectionHeader(titulo = stringResource(R.string.my_profile))
    }
}