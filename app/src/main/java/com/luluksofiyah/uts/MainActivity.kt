package com.luluksofiyah.uts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.luluksofiyah.uts.ui.theme.UTSTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UTSTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun ArtSpaceApp() {
    var currentIndex by remember { mutableStateOf(0) }
    val artList = ArtData.artList

    Column {
        ViewArt(art = artList[currentIndex])
        Spacer(modifier = Modifier.weight(1f))
        ViewName(artList[currentIndex])
        Spacer(modifier = Modifier.height(30.dp))
        ViewButton(
            onPreviousClick = {
                currentIndex = max(0, currentIndex - 1)
            },
            onNextClick = {
                currentIndex++
            },
            isLastArt = currentIndex == artList.size - 1
        )
    }
}

@Composable
fun ViewArt(art: Art) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(430.dp)
            .background(color = Color.White)
            .shadow(
                elevation = 6.dp,
            )
    ) {
        Image(
            modifier = Modifier
                .padding(40.dp)
                .fillMaxSize(),
            painter = painterResource(id = art.imageResource),
            contentDescription = "Image",
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun ViewName(art: Art) {
    val customText = buildAnnotatedString {
        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
            append(art.artist)
        }
        append(" (${art.year})")
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color(0xFFECEBF4))
    ) {
        Column(
            modifier = Modifier.padding(15.dp)
        ) {
            Text(
                art.name,
                style = TextStyle(fontSize = 20.sp)
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                customText,
                style = TextStyle(
                    fontSize = 15.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Normal
                )
            )
        }
    }
}

@Composable
fun ViewButton(onPreviousClick: () -> Unit, onNextClick: () -> Unit, isLastArt: Boolean) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth()
    ) {
        CustomButton(text = "Previous", logicButton = onPreviousClick)
        CustomButton(text = "Next") {
            if (!isLastArt) {
                onNextClick()
            }
        }
    }
}

@Composable
fun CustomButton(text: String, logicButton: () -> Unit) {
    Button(
        onClick = logicButton,
        modifier = Modifier.width(150.dp)
    ) {
        Text(text)
    }
}

@Preview
@Composable
fun previewTest(){
    ArtSpaceApp()
}