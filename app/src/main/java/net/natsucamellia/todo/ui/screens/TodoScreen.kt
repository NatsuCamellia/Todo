package net.natsucamellia.todo.ui.screens

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import net.natsucamellia.todo.R
import net.natsucamellia.todo.ui.nav.TopBarScaffold

@Composable
fun TodoScreen(
    onClickSettings: () -> Unit
) {
    TopBarScaffold(
        title = stringResource(R.string.todo),
        onClickSettings = onClickSettings,
        fab = {
            FloatingActionButton(onClick = { /*TODO*/ }) {
                Icon(Icons.Default.Add, null)
            }
        }
    ) {

    }
}