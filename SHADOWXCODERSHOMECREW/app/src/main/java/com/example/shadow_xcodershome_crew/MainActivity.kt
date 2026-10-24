package com.example.shadow_xcodershome_crew

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.shadow_xcodershome_crew.navigation.HomeCrewNavGraph
import com.example.shadow_xcodershome_crew.ui.theme.SHADOWXCODERSHOMECREWTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SHADOWXCODERSHOMECREWTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    HomeCrewNavGraph()
                }
            }
        }
    }
}
