package com.example.shadow_xcodershome_crew.feature.worker

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import com.example.shadow_xcodershome_crew.ui.theme.SHADOWXCODERSHOMECREWTheme

sealed class WorkerTab(val route: String, val title: String, val icon: ImageVector) {
    data object Dashboard : WorkerTab("dashboard", "Dashboard", Icons.Rounded.Dashboard)
    data object Earnings : WorkerTab("earnings", "Earnings", Icons.Rounded.AccountBalanceWallet)
    data object Skills : WorkerTab("skills", "Skills", Icons.Rounded.Verified)
    data object Proof : WorkerTab("proof", "Proof", Icons.Rounded.PhotoCamera)
    data object Roadmap : WorkerTab("roadmap", "Growth", Icons.Rounded.TrendingUp)
    data object Profile : WorkerTab("profile", "Profile", Icons.Rounded.Person)
}

@Composable
fun WorkerHubScreen(
    onSignOut: () -> Unit
) {
    val tabs = listOf(
        WorkerTab.Dashboard,
        WorkerTab.Earnings,
        WorkerTab.Skills,
        WorkerTab.Proof,
        WorkerTab.Roadmap,
        WorkerTab.Profile
    )

    var selectedTab by remember { mutableStateOf<WorkerTab>(WorkerTab.Dashboard) }

    Scaffold(
        bottomBar = {
            NavigationBar {
                tabs.forEach { tab ->
                    NavigationBarItem(
                        icon = { Icon(tab.icon, contentDescription = tab.title) },
                        label = { Text(tab.title) },
                        selected = selectedTab == tab,
                        onClick = { selectedTab = tab }
                    )
                }
            }
        }
    ) { innerPadding ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            when (selectedTab) {
                is WorkerTab.Dashboard -> WorkerDashboardScreen(
                    onNavigateToEarnings = { selectedTab = WorkerTab.Earnings },
                    onNavigateToSkills = { selectedTab = WorkerTab.Skills },
                    onNavigateToProofOfWork = { selectedTab = WorkerTab.Proof },
                    onNavigateToRoadmap = { selectedTab = WorkerTab.Roadmap },
                    onNavigateToBookings = { selectedTab = WorkerTab.Profile }
                )
                is WorkerTab.Earnings -> EarningsLedgerScreen(
                    onBackClick = { selectedTab = WorkerTab.Dashboard }
                )
                is WorkerTab.Skills -> SkillPassportScreen(
                    onBackClick = { selectedTab = WorkerTab.Dashboard }
                )
                is WorkerTab.Proof -> ProofOfWorkScreen(
                    onBackClick = { selectedTab = WorkerTab.Dashboard }
                )
                is WorkerTab.Roadmap -> GrowthRoadmapScreen(
                    onBackClick = { selectedTab = WorkerTab.Dashboard }
                )
                is WorkerTab.Profile -> WorkerProfileSettingsScreen(
                    onSignOut = onSignOut,
                    onBackClick = { selectedTab = WorkerTab.Dashboard }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WorkerHubScreenPreview() {
    SHADOWXCODERSHOMECREWTheme {
        WorkerHubScreen(
            onSignOut = {}
        )
    }
}
