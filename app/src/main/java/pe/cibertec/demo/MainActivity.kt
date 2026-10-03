package pe.cibertec.demo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import pe.cibertec.demo.ui.components.AppBottomBar
import pe.cibertec.demo.ui.navigation.AppDestinations
import pe.cibertec.demo.ui.navigation.AppNavigation
import pe.cibertec.demo.ui.screens.ListaComprasScreen
import pe.cibertec.demo.ui.theme.CibertecdemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CibertecdemoTheme {
                val navController = rememberNavController()
                val currentDestination by navController.currentBackStackEntryAsState()
                val currentRoute = currentDestination?.destination?.route
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        if (currentRoute != AppDestinations.Inicio.route) {
                            AppBottomBar(
                                navController = navController
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
