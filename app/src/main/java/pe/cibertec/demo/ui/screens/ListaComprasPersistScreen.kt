package pe.cibertec.demo.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import pe.cibertec.demo.R
import pe.cibertec.demo.ui.components.DeleteDialog
import pe.cibertec.demo.ui.components.LottieLoadingDialog
import pe.cibertec.demo.ui.components.ProductoCard
import pe.cibertec.demo.ui.components.ProductoDialog
import pe.cibertec.demo.ui.components.SectionHeader
import pe.cibertec.demo.ui.model.Producto
import pe.cibertec.demo.ui.model.productosDemo
import pe.cibertec.demo.ui.theme.CibertecdemoTheme
import pe.cibertec.demo.ui.theme.Dimensions
import kotlin.time.Duration.Companion.milliseconds

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListaComprasPersistScreen(
    modifier: Modifier = Modifier,
) {
    var productos by remember { mutableStateOf(productosDemo) }
    var productoSeleccionado by remember { mutableStateOf<Producto?>(null) }
    var mostrarDialog by remember { mutableStateOf(false) }
    var mostrarBottomsheet by remember { mutableStateOf(false) }
    var mostrarDeleteDialog by remember { mutableStateOf(false) }
    var mostrarLoading by remember { mutableStateOf(false) }

    Column(
        modifier = modifier.fillMaxSize()
            .padding(16.dp)
            .background(colorResource(R.color.blanco))
    ) {
        SectionHeader(titulo = stringResource(R.string.shopping_list))
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(Dimensions.itemSpacing)
        ) {
            items(
                items = productos,
                key = {
                    it.nombre
                }
            ) { producto ->
                ProductoCard(
                    producto = producto,
                    onCompradoChange = { comprado ->
                        productos = productos.map {
                            if (it == producto) {
                                it.copy(
                                    comprado = comprado
                                )
                            } else {
                                it
                            }
                        }
                    },
                    onClick = {
                        productoSeleccionado = producto
                        mostrarBottomsheet = true
                    }
                )
                HorizontalDivider()
            }
        }
    }

    if (mostrarDialog && productoSeleccionado != null) {
        ProductoDialog(
            producto = productoSeleccionado!!,
            onDismiss = {
                productoSeleccionado = null
                mostrarDialog = false
            }
        )
    }

    if (mostrarBottomsheet && productoSeleccionado != null) {
        ModalBottomSheet(
            onDismissRequest = {
                mostrarBottomsheet = false
            }
        ) {
            Column(
                modifier = Modifier.fillMaxWidth()
                    .padding(24.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp),
            ) {
                Text(
                    text = productoSeleccionado!!.nombre
                )
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = {
                        mostrarDialog = true
                        mostrarBottomsheet = false
                    }
                ) {
                    Text(
                        text = "Ver producto"
                    )
                }
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = {
                        mostrarBottomsheet = false
                        mostrarDeleteDialog = true
                    }
                ) {
                    Text(
                        text = "Eliminar producto"
                    )
                }
            }
        }
    }

    if (mostrarDeleteDialog && productoSeleccionado != null) {
        DeleteDialog(
            nombreProducto = productoSeleccionado!!.nombre,
            onConfirm = {
                mostrarDeleteDialog = false
                mostrarLoading = true
                productos = productos.filter {
                    it != productoSeleccionado
                }
                productoSeleccionado = null
            },
            onDismiss = {
                mostrarDeleteDialog = false
            }
        )
    }

    LaunchedEffect(mostrarLoading) {
        if (mostrarLoading) {
            delay(3000.milliseconds)
            mostrarLoading = false
        }
    }

    if (mostrarLoading) {
//        LoadingDialog(mensaje = "Eliminando producto...")
        LottieLoadingDialog(mensaje = "Eliminando producto...")
    }
}

@Preview
@Composable
fun ListaComprasPersistScreenPreview() {
    CibertecdemoTheme {
        ListaComprasPersistScreen(
            modifier = Modifier.fillMaxSize()
        )
    }
}
