package pe.cibertec.demo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch
import pe.cibertec.demo.data.local.DatabaseHelper
import pe.cibertec.demo.data.preferences.SessionManager
import pe.cibertec.demo.ui.components.AppBottomBar
import pe.cibertec.demo.ui.components.AppDrawer
import pe.cibertec.demo.ui.navigation.AppDestinations
import pe.cibertec.demo.ui.navigation.AppNavigation
import pe.cibertec.demo.ui.screens.ListaComprasScreen
import pe.cibertec.demo.ui.theme.CibertecdemoTheme

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val dbHelper = DatabaseHelper(this)
        val db = dbHelper.writableDatabase

        // Por buenas prácticas se cierra la BBDD siempre tras su uso
//        db.close()

        setContent {
            CibertecdemoTheme {
                val navController = rememberNavController()
                val currentDestination by navController.currentBackStackEntryAsState()
                val currentRoute = currentDestination?.destination?.route
                val drawerState = rememberDrawerState(
                    initialValue = DrawerValue.Closed
                )
                val scope = rememberCoroutineScope()
                AppDrawer(
                    drawerState = drawerState,
                    scope = scope,
                    navController = navController,
                ) {
                    Scaffold(
                        modifier = Modifier.fillMaxSize(),
                        bottomBar = {
                            if (currentRoute != AppDestinations.Inicio.route) {
                                AppBottomBar(
                                    navController = navController
                                )
                            }
                        },
                        topBar = {
                            if (currentRoute != AppDestinations.Inicio.route) {
                                TopAppBar(
                                    title = {
                                        Text(
                                            text = "Lista de compras",
                                        )
                                    },
                                    navigationIcon = {
                                        IconButton(
                                            onClick = {
                                                scope.launch {
                                                    drawerState.open()
                                                }
                                            }
                                        ) {
                                            Icon(
                                                painter = painterResource(R.drawable.ic_menu),
                                                contentDescription = null,
                                            )
                                        }
                                    },
                                )
                            }
                        }
                    ) { innerPadding ->
                        AppNavigation(
                            modifier = Modifier.padding(innerPadding).background(Color.White),
                            navController = navController,
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainActivityPreview() {
    CibertecdemoTheme {
        ListaComprasScreen()
    }
}

@Preview(showBackground = true)
@Composable
fun MainActivityFullScreenPreview() {
    CibertecdemoTheme {
        ListaComprasScreen(
            modifier = Modifier
                .fillMaxSize(),
        )
    }
}
