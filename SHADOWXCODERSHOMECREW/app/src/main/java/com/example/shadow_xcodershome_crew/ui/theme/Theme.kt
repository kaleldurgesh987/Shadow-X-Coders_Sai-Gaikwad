package com.example.shadow_xcodershome_crew.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val LightColorScheme = lightColorScheme(
    primary = HomeCrewPrimaryGreen,
    onPrimary = HomeCrewOnPrimary,
    primaryContainer = HomeCrewPrimaryGreenLight,
    onPrimaryContainer = HomeCrewPrimaryGreenDark,
    secondary = HomeCrewAccentYellow,
    onSecondary = HomeCrewTextPrimaryLight,
    secondaryContainer = HomeCrewAccentYellowLight,
    onSecondaryContainer = HomeCrewAccentYellowDark,
    background = HomeCrewBackgroundLight,
    onBackground = HomeCrewTextPrimaryLight,
    surface = HomeCrewSurfaceLight,
    onSurface = HomeCrewTextPrimaryLight
)

private val DarkColorScheme = darkColorScheme(
    primary = HomeCrewPrimaryGreenLight,
    onPrimary = HomeCrewOnPrimaryDark,
    primaryContainer = HomeCrewPrimaryGreenDark,
    onPrimaryContainer = HomeCrewPrimaryGreenLight,
    secondary = HomeCrewAccentYellow,
    onSecondary = HomeCrewTextPrimaryDark,
    secondaryContainer = HomeCrewAccentYellowDark,
    onSecondaryContainer = HomeCrewAccentYellowLight,
    background = HomeCrewBackgroundDark,
    onBackground = HomeCrewTextPrimaryDark,
    surface = HomeCrewSurfaceDark,
    onSurface = HomeCrewTextPrimaryDark
)

@Composable
fun SHADOWXCODERSHOMECREWTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
