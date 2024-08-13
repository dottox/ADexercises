package com.example.ad_composearticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ad_composearticle.ui.theme.ADComposeArticleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ADComposeArticleTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Article(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Article(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .wrapContentSize()
    ) {

        val image = painterResource(id = R.drawable.bg_compose_background)
        // Article Image
        Image(
            painter = image,
            contentDescription = "Compose background",
            modifier = Modifier.fillMaxWidth()
        )

        // Article Title
        Text (
            text = stringResource(R.string.article_title),
            fontSize = 24.sp,
            modifier = Modifier
                .padding(16.dp)
        )

        // Article Body 1
        Text(
            text = stringResource(R.string.article_body1),
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp)

        )

        // Article Body 2
        Text (
            text = stringResource(R.string.article_body2),
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .padding(16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MyPreview() {
    ADComposeArticleTheme {
        Article()
    }
}