package pe.cibertec.demo.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import pe.cibertec.demo.ui.screens.ListaComprasPersistScreen
import pe.cibertec.demo.ui.screens.ListaComprasScreen
import pe.cibertec.demo.ui.screens.LoginScreen
import pe.cibertec.demo.ui.screens.PerfilScreen

@Composable
fun AppNavigation(
    modifier: Modifier = Modifier,
    navController: NavHostController,
) {

    NavHost(
        navController = navController,
        startDestination = AppDestinations.Inicio.route,
        modifier = modifier,
    ) {
        composable(AppDestinations.Inicio.route) {
            LoginScreen(
                onLoginSuccess = {
                    navController.navigate(AppDestinations.ListaPersist.route)
                }
            )
        }
        composable(AppDestinations.Lista.route) {
            ListaComprasScreen()
        }
        composable(AppDestinations.ListaPersist.route) {
            ListaComprasPersistScreen()
        }
        composable(AppDestinations.Perfil.route) {
            PerfilScreen()
        }
    }
}
