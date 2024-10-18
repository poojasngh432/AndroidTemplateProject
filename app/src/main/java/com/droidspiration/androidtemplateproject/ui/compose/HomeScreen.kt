package com.droidspiration.androidtemplateproject.ui.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.droidspiration.androidtemplateproject.ui.theme.AndroidTemplateProjectTheme

@Composable
fun HomeScreen() {
    val museums = listOf("Metropolitan Museum of Art",
        "Art Institute of Chicago",
        "Harvard Art Museums")

    LazyColumn (
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 32.dp)
    ) {
        items(museums) { museum ->
            MuseumCard(museum = museum)
        }
    }
}

@Composable
fun MuseumCard(museum: String) {
    Column(
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = museum,
            style = MaterialTheme.typography.titleMedium,
            textAlign = TextAlign.Center
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    AndroidTemplateProjectTheme {
        HomeScreen()
    }
}