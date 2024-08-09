package net.natsucamellia.todo.ui.nav

import android.content.res.Configuration
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.rememberNavController

val bottomNavItems = listOf(
    NavRoutes.Todo,
    NavRoutes.Calendar,
    NavRoutes.Pomodoro
)

@Composable
fun NavContainer(
    initialTab: NavRoutes
) {
    val navController = rememberNavController()

    var selectedRoute by remember {
        mutableStateOf(initialTab)
    }

    val orientation = LocalConfiguration.current.orientation
    Scaffold(
        bottomBar = {
            if (orientation == Configuration.ORIENTATION_PORTRAIT) {
                NavigationBar {
                    bottomNavItems.forEach {
                        NavigationBarItem(
                            selected = it == selectedRoute,
                            onClick = {
                                selectedRoute = it
                                navController.navigate(it.route)
                            },
                            icon = {
                                Icon(it.icon, null)
                            },
                            label = {
                                Text(stringResource(it.stringRes))
                            }
                        )
                    }
                }
            }
        }
    ) { paddingValue ->
        Row(
            modifier = Modifier
                .padding(paddingValue)
                .consumeWindowInsets(paddingValue)
                .windowInsetsPadding(
                    WindowInsets.safeDrawing.only(
                        WindowInsetsSides.Horizontal
                    )
                )
        ) {
            if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
                NavigationRail {
                    bottomNavItems.forEach {
                        NavigationRailItem(
                            selected = it == selectedRoute,
                            onClick = {
                                selectedRoute = it
                                navController.navigate(it.route)
                            },
                            icon = {
                                Icon(it.icon, null)
                            },
                            label = {
                                Text(stringResource(it.stringRes))
                            }
                        )
                    }
                }
            }
            AppNavHost(navController = navController, startDestination = initialTab)
        }
    }
}