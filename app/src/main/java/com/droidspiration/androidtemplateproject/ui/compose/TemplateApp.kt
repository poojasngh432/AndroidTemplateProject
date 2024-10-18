package com.droidspiration.androidtemplateproject.ui.compose

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.droidspiration.androidtemplateproject.ui.theme.AndroidTemplateProjectTheme

@Composable
fun TemplateApp() {
    val navController = rememberNavController()

    AndroidTemplateProjectTheme {
        NavHost(navController = navController, startDestination = "main") {
            composable("main") { HomeScreen() }
        }
    }
}