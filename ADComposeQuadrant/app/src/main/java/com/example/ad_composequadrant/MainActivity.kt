package com.example.ad_composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ad_composequadrant.ui.theme.ADComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ADComposeQuadrantTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ComposeQuadrant(
                        Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}


@Composable
fun ComposeQuadrant(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color(android.graphics.Color.BLUE))
    ) {

        val quadrantModifier: Modifier = Modifier
            .weight(1f)

        Row (
            modifier = Modifier
                .background(color = Color(android.graphics.Color.RED))
                .fillMaxWidth()
                .weight(1f)
        ) {
            Quadrant(
                stringResource(R.string.text_composable_title),
                stringResource(R.string.text_composable_body),
                1,
                quadrantModifier
            )
            Quadrant(
                stringResource(R.string.image_composable_title),
                stringResource(R.string.image_composable_body),
                2,
                quadrantModifier
            )
        }
        Row (
            modifier = Modifier
                .background(color = Color(android.graphics.Color.GREEN))
                .fillMaxWidth()
                .weight(1f)
        ) {
            Quadrant(
                stringResource(R.string.row_composable_title),
                stringResource(R.string.text_composable_body),
                3,
                quadrantModifier
            )
            Quadrant(
                stringResource(R.string.column_composable_title),
                stringResource(R.string.column_composable_body),
                4,
                quadrantModifier
            )
        }
    }
}

@Composable
fun Quadrant(title: String, body: String, colorID: Int ,modifier: Modifier = Modifier) {

    val color: Color = when (colorID) {
        1 -> colorResource(id = R.color.palid_gray)
        2 -> colorResource(id = R.color.palid_skyblue)
        3 -> colorResource(id = R.color.nonpalid_skyblue)
        4 -> colorResource(id = R.color.nonpalid_gray)
        else -> Color(android.graphics.Color.BLACK)
    }

    Column (
        verticalArrangement = androidx.compose.foundation.layout.Arrangement.Center,
        modifier = modifier
            .background(color)
            .padding(16.dp)
            .fillMaxSize()
    ) {
        Text (
            text = title,
            color = Color(android.graphics.Color.BLACK),
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(16.dp)
        )
        Text (
            text = body,
            color = Color(android.graphics.Color.BLACK),
            textAlign = TextAlign.Justify,
        )
    }

}

@Preview(showSystemUi = true)
@Composable
fun ComposeQuadrantPreview() {
    ADComposeQuadrantTheme {
        ComposeQuadrant()
    }
}