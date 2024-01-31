package com.luluksofiyah.uas.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.luluksofiyah.uas.ui.components.main.UasApp
import com.luluksofiyah.uas.ui.theme.UASTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private var isSplashScreenClosed = false
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen().setKeepOnScreenCondition {
            !isSplashScreenClosed
        }
        super.onCreate(savedInstanceState)
        setContent {
            UASTheme {
                LaunchedEffect(key1 = Unit) {
                    delay(2000)
                    isSplashScreenClosed = true
                }
                UasApp()
            }
        }
    }
}

@Preview
@Composable
fun GreetingPreview() {
    UASTheme {
     UasApp()
    }
}