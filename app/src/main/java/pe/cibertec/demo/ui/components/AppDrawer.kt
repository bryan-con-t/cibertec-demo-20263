package pe.cibertec.demo.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import pe.cibertec.demo.R
import pe.cibertec.demo.ui.navigation.AppDestinations
import pe.cibertec.demo.ui.theme.Dimensions
import pe.cibertec.demo.ui.theme.Secondary
import pe.cibertec.demo.ui.theme.White
import kotlin.time.Duration.Companion.milliseconds

@Composable
fun AppDrawer(
    drawerState: DrawerState,
    scope: CoroutineScope,
    navController: NavController,
    content: @Composable () -> Unit,
) {
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Box(
                    modifier = Modifier.height(240.dp)
                        .background(Secondary)
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Bottom,
                    ) {
                        Text(
                            text = "Hola,\nUsuario",
                            modifier = Modifier.padding(Dimensions.itemSpacing),
                            style = MaterialTheme.typography.headlineSmall,
                            color = White,
                        )
                    }
                }
                NavigationDrawerItem(
                    label = {
                        Text(
                            text = "Lista de compras simple",
                        )
                    },
                    selected = false,
                    onClick = {
                        navController.navigate(
                            AppDestinations.Lista.route
                        )
                        scope.launch {
                            delay(500.milliseconds)
                            drawerState.close()
                        }
                    },
                    icon = {
                        Icon(
                            painter = painterResource(R.drawable.ic_home),
                            contentDescription = null,
                        )
                    }
                )
                NavigationDrawerItem(
                    label = {
                        Text(
                            text = "Lista de compras SQLite",
                        )
                    },
                    selected = false,
                    onClick = {
                        navController.navigate(
                            AppDestinations.ListaPersist.route
                        )
                        scope.launch {
                            delay(500.milliseconds)
                            drawerState.close()
                        }
                    },
                    icon = {
                        Icon(
                            painter = painterResource(R.drawable.ic_database),
                            contentDescription = null,
                        )
                    }
                )
                NavigationDrawerItem(
                    label = {
                        Text(
                            text = "Perfil",
                        )
                    },
                    selected = false,
                    onClick = {
                        navController.navigate(
                            AppDestinations.Perfil.route
                        )
                        scope.launch {
                            delay(500.milliseconds)
                            drawerState.close()
                        }
                    },
                    icon = {
                        Icon(
                            painter = painterResource(R.drawable.ic_perfil),
                            contentDescription = null,
                        )
                    }
                )
            }
        }
    ) {
        content()
    }
}