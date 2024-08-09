package net.natsucamellia.todo.ui.nav

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.TaskAlt
import androidx.compose.material.icons.filled.Timer
import androidx.compose.ui.graphics.vector.ImageVector
import net.natsucamellia.todo.R

sealed class NavRoutes(
    val route: String,
    @StringRes val stringRes: Int,
    val icon: ImageVector
) {
    data object Todo : NavRoutes("todo", R.string.todo, Icons.Default.TaskAlt)
    data object Calendar : NavRoutes("calendar", R.string.calendar, Icons.Default.CalendarMonth)
    data object Pomodoro : NavRoutes("pomodoro", R.string.pomodoro, Icons.Default.Timer)
    data object Settings : NavRoutes("settings", R.string.settings, Icons.Default.Settings)
}