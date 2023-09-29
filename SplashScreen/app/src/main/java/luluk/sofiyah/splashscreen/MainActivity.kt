package luluk.sofiyah.splashscreen

import android.os.Bundle
import android.view.animation.OvershootInterpolator
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHost
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
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFF202020)
                ) {
                    Nav()
                }
            }
        }
    }
}

@Composable
fun Nav(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "splash_screen"){
        composable("splash_screen"){
            SplashScreen(navController= navController)
        }
        composable("main_screen"){
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                Text(text = "Halaman Utama", color = Color.White)
            }
        }
    }
}

@Composable
fun SplashScreen(navController: NavController){
//    val scale = remember{
//       Animatable(Color(0xffb99aff))
//    }
//    LaunchedEffect(key1 = true){
//        scale.animateTo(
//            targetValue = 0.3f,
//            animationSpec = tween(
//                durationMillis = 500,
//                easing = {
//                    OvershootInterpolator(2f).getInterpolation(it)
//                }
//            )
//        )
//        delay(timeMillis = 3000L)
        navController.navigate("main_screen")
    }
//    Box(
//        contentAlignment = Alignment.Center,
//        modifier = Modifier.fillMaxSize()
//    ){
//        Image(
//            painter = painterResource(id = R.drawable.logo),
//            contentDescription = "UTDI_logo",
//            modifier = Modifier.scale(scale.value)
//        )
//    }
//}

@Preview
@Composable
fun NavPreview(){
    Nav()
}
