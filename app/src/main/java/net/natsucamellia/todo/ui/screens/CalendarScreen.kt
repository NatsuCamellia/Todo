package net.natsucamellia.todo.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import net.natsucamellia.todo.R
import net.natsucamellia.todo.ui.nav.TopBarScaffold

@Composable
fun CalendarScreen(
    onClickSettings: () -> Unit
) {
    TopBarScaffold(
        title = stringResource(R.string.calendar),
        onClickSettings = onClickSettings
    ) {

    }
}