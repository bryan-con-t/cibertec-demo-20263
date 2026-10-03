package pe.cibertec.demo.ui.components

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import pe.cibertec.demo.R
import pe.cibertec.demo.ui.navigation.AppDestinations
import pe.cibertec.demo.ui.theme.CibertecdemoTheme

@Composable
fun AppBottomBar(
    navController: NavHostController
) {
    val currentDestination = navController.currentBackStackEntryAsState().value?.destination
    NavigationBar {
        NavigationBarItem(
            selected = currentDestination?.route == AppDestinations.Lista.route,
            label = {
                Text(
                    text = stringResource(R.string.shopping_list)
                )
            },
            icon = {
                Icon(
                    painter = painterResource(R.drawable.ic_home),
                    contentDescription = null,
                )
            },
            onClick = {
                navController.navigate(
                    AppDestinations.Lista.route
                )
            }
        )
        NavigationBarItem(
            selected = currentDestination?.route == AppDestinations.ListaPersist.route,
            label = {
                Text(
                    text = stringResource(R.string.shopping_list)
                )
            },
            icon = {
                Icon(
                    painter = painterResource(R.drawable.ic_database),
                    contentDescription = null,
                )
            },
            onClick = {
                navController.navigate(
                    AppDestinations.ListaPersist.route
                )
            }
        )
        NavigationBarItem(
            selected = currentDestination?.route == AppDestinations.Perfil.route,
            label = {
                Text(
                    text = stringResource(R.string.my_profile)
                )
            },
            icon = {
                Icon(
                    painter = painterResource(R.drawable.ic_perfil),
                    contentDescription = null,
                )
            },
            onClick = {
                navController.navigate(
                    AppDestinations.Perfil.route
                )
            }
        )
    }
}

@Preview
@Composable
fun AppBottomBarPreview() {
    CibertecdemoTheme {
        AppBottomBar(
            rememberNavController()
        )
    }
}