package com.example.ad_businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ad_businesscard.ui.theme.ADBusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ADBusinessCardTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Card(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Card(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = modifier
            .fillMaxSize()
            .background(Color(0x1F21A03F))
            .padding(16.dp)
    ) {
        Column {
            TitleRow(
                name = "Android Developer",
                imageId = R.drawable.android_developer_logo,
                imageDescription = "Android Logo"
            )
            TitleRow(
                name = "Cloud Specialist",
                imageId = R.drawable.cloud_logo,
                imageDescription = "Cloud Logo"
            )
        }

        Column (
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image (
                painter = painterResource(R.drawable.android_logo),
                contentDescription = "Android Logo",
                modifier = Modifier
                    .size(128.dp)
                    .background(Color(0xFF51C06F))
            )

            Spacer (
                modifier = Modifier
                    .height(16.dp)
            )

            Text (
                text = "Ignacio Suárez",
                fontSize = 32.sp,
                fontFamily = FontFamily.Monospace
            )

            Text (
                text = "Enthusiastic Programmer",
                fontSize = 16.sp,
                fontFamily = FontFamily.Monospace,
                color = Color(0xFF21A03F)
            )
        }


        Column {
            TitleRow(
                name = "091 234 567",
                imageId = R.drawable.phone_logo,
                imageDescription = "Phone Logo"
            )
            TitleRow(
                name = "prueba@test.com",
                imageId = R.drawable.mail_logo,
                imageDescription = "Mail Logo"
            )
        }
    }
}

@Composable
fun TitleRow(name: String, imageId: Int, imageDescription: String) {
    Row (
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .height(32.dp)
    ) {
        Image (
            painter = painterResource(imageId),
            contentDescription = imageDescription,
            modifier = Modifier
                .size(22.dp)
        )

        Text (
            text = name,
            fontSize = 16.sp,
            fontFamily = FontFamily.Serif,
            modifier = Modifier
                .padding(start = 5.dp)
        )


    }

}

@Preview(showSystemUi = true)
@Composable
fun CardPreview() {
    ADBusinessCardTheme {
        Card()
    }
}