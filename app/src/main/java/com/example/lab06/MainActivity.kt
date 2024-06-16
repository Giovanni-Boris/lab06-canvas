package com.example.lab06

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lab06.ui.theme.LAB06Theme
import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            LAB06Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MyCanvasWithCircle(150f,540f)
                    innerPadding
                }
            }
        }
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}


@Composable
fun MyCanvasWithCircle(x: Float, y: Float) {
    val margin = with(LocalDensity.current) { 16.dp.toPx() }


    Canvas(modifier = Modifier.fillMaxSize()) {
        val screenWidth = size.width
        val screenHeight = size.height


        // Calculate rectangle bounds with margin
        val rectLeft = margin
        val rectTop = margin
        val rectRight = screenWidth - margin
        val rectBottom = screenHeight - margin


        // Ensure (x, y) coordinates are within bounds
        val adjustedX = x.coerceIn(rectLeft, rectRight)
        val adjustedY = y.coerceIn(rectTop, rectBottom)
        Log.d("Coercion","  "+rectLeft +" "+ rectRight+"  "+ rectTop+"  "+rectBottom+"  "+ x+"  "+y);
        // Draw the filled rectangle
        drawRect(color = Color.Black, topLeft = Offset(rectLeft, rectTop), size = Size(rectRight - rectLeft, rectBottom - rectTop))


        // Draw the circle at adjusted coordinates
        drawCircle(color = Color.Red, center = Offset(adjustedX, adjustedY), radius = 30.dp.toPx())
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LAB06Theme {
        Greeting("Android")
    }
}
