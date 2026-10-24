package com.example.shadow_xcodershome_crew.feature.customer

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.shadow_xcodershome_crew.data.HomeCrewRepository
import com.example.shadow_xcodershome_crew.ui.theme.SHADOWXCODERSHOMECREWTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryWorkersScreen(
    categoryId: String,
    categoryName: String,
    onBackClick: () -> Unit,
    onWorkerClick: (String) -> Unit
) {
    val workers = HomeCrewRepository.workers.filter { it.categoryId == categoryId }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("$categoryName Experts", fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Rounded.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(workers) { worker ->
                WorkerCard(
                    worker = worker,
                    onClick = { onWorkerClick(worker.id) }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CategoryWorkersScreenPreview() {
    SHADOWXCODERSHOMECREWTheme {
        CategoryWorkersScreen(
            categoryId = "electrician",
            categoryName = "Electrician",
            onBackClick = {},
            onWorkerClick = {}
        )
    }
}
