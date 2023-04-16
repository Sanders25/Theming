package com.example.theming

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val isLightTheme =
            resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK == Configuration.UI_MODE_NIGHT_NO

        setTheme(R.style.Theme_AppTheme)
        installSplashScreen()
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(
            window,
            false,
        )
        val windowInsetsController = WindowCompat.getInsetsController(
            window,
            window.decorView,
        )

        windowInsetsController.isAppearanceLightStatusBars = isLightTheme
        windowInsetsController.isAppearanceLightNavigationBars = isLightTheme

        setContentView(R.layout.activity_main)
    }
}