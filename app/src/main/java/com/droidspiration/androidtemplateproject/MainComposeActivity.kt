package com.droidspiration.androidtemplateproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.droidspiration.androidtemplateproject.ui.compose.InfoCuspTestScreen
import com.droidspiration.androidtemplateproject.ui.theme.AndroidTemplateProjectTheme

class MainComposeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidTemplateProjectTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    InfoCuspTestScreen(
                        modifier = Modifier
                            .padding(innerPadding)
                    )
                }
            }
        }
    }
}