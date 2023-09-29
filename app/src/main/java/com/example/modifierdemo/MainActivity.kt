package com.example.modifierdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.modifierdemo.ui.theme.ModifierDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ModifierDemoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DemoScreen()
                }
            }
        }
    }
}

/**
 * Trabalhando com modificadores usando modificadores em funcoes compostas e passando os
 * modificadores como parametro de pai para filho.
 */

@Composable
private fun DemoScreen() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Header()
        Body()
    }
}

@Composable
private fun Header() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.Black)
            .border(1.dp, Color.Cyan),
        Arrangement.Center
    ) {
        CustomImage(image = R.drawable.ic_android_black_24dp)
    }
}

@Composable
private fun Body() {
    val textModifier: Modifier = Modifier.background(Color.Yellow)
    Column(
        modifier = Modifier.fillMaxSize(),
        Arrangement.Center,
        Alignment.CenterHorizontally
    ) {
        Hello(textModifier)
    }
}

@Composable
private fun Hello(modifier: Modifier) {
    Text(
        text = "Hello Composable",
        fontSize = 22.sp,
        fontWeight = FontWeight.Bold,
        modifier = modifier
            .border(2.dp, Color.Black)
            .padding(10.dp)
    )
}

@Composable
private fun CustomImage(image: Int) {
    Image(
        painter = painterResource(image),
        contentDescription = "imagem legal"
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ModifierDemoTheme {
        DemoScreen()
    }
}