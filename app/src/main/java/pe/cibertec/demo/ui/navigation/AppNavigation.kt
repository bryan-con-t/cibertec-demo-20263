package pe.cibertec.demo.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import pe.cibertec.demo.ui.screens.ListaComprasScreen
import pe.cibertec.demo.ui.screens.LoginScreen

@Composable
fun AppNavigation(
    modifier: Modifier = Modifier
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "login",
        modifier = modifier,
    ) {
        composable("login") {
            LoginScreen(
                onLoginSuccess = {
                    navController.navigate("lista_compras")
                }
            )
        }
        composable("lista_compras") {
            ListaComprasScreen()
        }
    }
}
