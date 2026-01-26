package com.example.movies.ui.theme

import androidx.compose.material3.darkColorScheme
import androidx.compose.ui.graphics.Color

val Primary80 = Color(0xFFE50914)
val BackgroundDark = Color(0xFF121212)
val SurfaceDark = Color(0xFF1E1E1E)
val TextPrimaryDark = Color(0xFFFFFFFF)
val ColorError = Color(0xFFF24E1E)
val Neutral60 = Color(0xFF8A91A8)

/**
 * Esquema de cores escuras do aplicativo
 * - primary: Cor primária usada para elementos de destaque.
 * - onPrimary: Cor do texto ou ícones sobre a cor primária.
 * - background: Cor de fundo principal do aplicativo.
 * - onBackground: Cor do texto ou ícones sobre a cor de fundo.
 */
internal val AppDarkColorScheme = darkColorScheme(
    primary = Primary80,
    onPrimary = Color.White,
    background = BackgroundDark,
    onBackground = TextPrimaryDark,
    surface = SurfaceDark,
    onSurface = TextPrimaryDark,
    secondary = Neutral60,
    onSecondary = TextPrimaryDark,
    error = ColorError,
    onError = Color.White
)

/**
 * Esquema de cores claras do aplicativo
 * - primary: Cor primária usada para elementos de destaque.
 * - onPrimary: Cor do texto ou ícones sobre a cor primária.
 * - background: Cor de fundo principal do aplicativo.
 * - onBackground: Cor do texto ou ícones sobre a cor de fundo.
 */
internal val AppLightColorScheme = darkColorScheme(
    primary = Primary80,
    onPrimary = Color.White,
    background = BackgroundDark,
    onBackground = TextPrimaryDark,
    surface = SurfaceDark,
    onSurface = TextPrimaryDark,
    secondary = Neutral60,
    onSecondary = TextPrimaryDark,
    error = ColorError,
    onError = Color.White
)