package com.mo.composeplayground.presentation.counter

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.mo.composeplayground.ui.theme.ColorPrimary


@Composable
fun CounterScreen(
    viewModel: CounterViewModel = hiltViewModel()
) {

    val num by viewModel.counter.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CounterText(num.toString())
        Spacer(modifier = Modifier.padding(top = 60.dp))

        Row{

            CounterButton(txt = "-") { viewModel.onDecreaseClicked() }

            Spacer(modifier = Modifier.padding(horizontal = 10.dp))

            CounterButton(txt = "+") { viewModel.onIncreaseClicked() }

        }
    }

}

@Composable
fun CounterText(num: String, modifier: Modifier = Modifier) {
    Text(
        text = num,
        fontSize = 28.sp,
        color = Color.Black,
        modifier = modifier
    )
}

@Composable
fun CounterButton(txt: String, click: () -> Unit) {

    val shape = RoundedCornerShape(16.dp)

    Button(
        colors = ButtonDefaults.buttonColors(
            containerColor = ColorPrimary
        ),
        shape = shape,
        onClick = { click() }
    ) {
        Text(
            text = txt,
            fontSize = 18.sp,
            color = Color.White,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
    }

}

@Preview(showBackground = true)
@Composable
fun CounterPreview() {
    CounterScreen()
}