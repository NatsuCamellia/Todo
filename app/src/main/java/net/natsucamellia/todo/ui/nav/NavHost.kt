package net.natsucamellia.todo.ui.nav

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import net.natsucamellia.todo.ui.screens.CalendarScreen
import net.natsucamellia.todo.ui.screens.PomodoroScreen
import net.natsucamellia.todo.ui.screens.SettingsScreen
import net.natsucamellia.todo.ui.screens.TodoScreen

@Composable
fun AppNavHost(
    navController: NavHostController,
    startDestination: NavRoutes,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = startDestination.route,
        modifier = modifier
    ) {
        composable(NavRoutes.Todo.route) {
            TodoScreen(onClickSettings = {
                navController.navigate(NavRoutes.Settings.route)
            })
        }
        composable(NavRoutes.Calendar.route) {
            CalendarScreen(onClickSettings = {
                navController.navigate(NavRoutes.Settings.route)
            })
        }
        composable(NavRoutes.Pomodoro.route) {
            PomodoroScreen(onClickSettings = {
                navController.navigate(NavRoutes.Settings.route)
            })
        }
        composable(NavRoutes.Settings.route) {
            SettingsScreen(onClickBack = {
                navController.popBackStack()
            })
        }
    }
}