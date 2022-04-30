package xyz.teamgravity.cleanarchitecturevalidation.presentation.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import xyz.teamgravity.cleanarchitecturevalidation.presentation.viewmodel.RegisterViewModel

@Composable
fun RegisterScreen(
    viewmodel: RegisterViewModel = hiltViewModel()
) {
    val context = LocalContext.current

    LaunchedEffect(key1 = viewmodel) {

    }
}