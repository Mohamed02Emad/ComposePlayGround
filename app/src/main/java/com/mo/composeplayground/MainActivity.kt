package com.mo.composeplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.mo.composeplayground.presentation.codeLinkLoginScreen.LoginScreen
import com.mo.composeplayground.presentation.counter.CounterScreen
import com.mo.composeplayground.presentation.newsScreen.NewsScreen
import com.mo.composeplayground.presentation.newsScreen.NewsViewModel
import com.mo.composeplayground.ui.theme.ComposePlayGroundTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePlayGroundTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                   // CounterScreen()
                   // LoginScreen(this)
                    NewsScreen(this)
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposePlayGroundTheme {
//        ShadowButton(
//            onClick = {}
//        ) {
//            Greeting("Android")
//        }
        CounterScreen()
    }
}