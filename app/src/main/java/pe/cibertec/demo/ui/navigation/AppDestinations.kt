package pe.cibertec.demo.ui.navigation

sealed class AppDestinations(
    val route: String
) {
    data object Inicio: AppDestinations("inicio")
    data object Lista: AppDestinations("lista")
    data object ListaPersist: AppDestinations("lista_persist")
    data object Perfil: AppDestinations("perfil")
}
