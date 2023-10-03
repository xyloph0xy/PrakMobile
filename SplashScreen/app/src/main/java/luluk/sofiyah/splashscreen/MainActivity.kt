package luluk.sofiyah.splashscreen

import android.os.Bundle
import android.view.animation.OvershootInterpolator
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.delay
import luluk.sofiyah.splashscreen.ui.theme.SplashScreenTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SplashScreenTheme {
                AppNavigation()
            }
        }
    }
}

@Composable
fun SplashScreen(navController: NavHostController) {
    val scale = remember {
        Animatable(1f)
    }
/** Fungsi composable dapat menggunakan remember API untuk menyimpan objek di memori. 
Nilai yang dihitung oleh remember disimpan dalam Komposisi selama komposisi awal dan nilai yang disimpan ditampilkan selama rekomposisi. 
remember dapat digunakan untuk menyimpan objek yang dapat diubah dan tidak dapat diubah.
**/

/**
Animatable adalah penampung nilai yang secara otomatis 
menganimasikan nilainya ketika nilai tersebut diubah melalui animateTo
**/

/** 

**/
    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 0.7f,
            animationSpec = tween(
                durationMillis = 900,
                easing = {
                    OvershootInterpolator(2f).getInterpolation(it)
                }
            )
        )
        delay(3000L)
        navController.navigate("main_screen")
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo_app),
            contentDescription = "UTDI_logo",
            modifier = Modifier.scale(scale.value)
        )
    }
}



@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "splash_screen") {
        composable("splash_screen") {
            SplashScreen(navController = navController)
        }
        composable("main_screen") {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(text = "Halaman Utama", color = Color.Black)
            }
        }
    }
}
