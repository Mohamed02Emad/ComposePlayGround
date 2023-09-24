package com.mo.composeplayground.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mo.composeplayground.utils.shadow

@Composable
fun ShadowButton(
    shadowColor: Color = Color.Gray,
    background: Color = Color.Blue,
    radius: Int = 15,
    onClick: () -> Unit,
    content: @Composable () -> Unit
) {
    val shape = RoundedCornerShape(radius.dp)
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = background),
        modifier = Modifier
            .padding( start = 5.dp , end = 5.dp)
            .clip(shape)
//            .shadow(
//                elevation = elevation.dp,
//                shape = shape,
//                spotColor = shadowColor,
//                ambientColor = shadowColor,
//            )
            .shadow(
                color = shadowColor,
                blurRadius = 100.dp,
                offsetY = 100.dp,
                spread = 0.dp
            )
            ,

        shape = shape
    )
    {
        content()
    }
}


@Preview
@Composable
fun Preview() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.White)
            .padding(horizontal = 0.dp, vertical = 10.dp)
        ,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        ShadowButton(
            shadowColor = Color.Red,
            background = Color.Red,
            onClick = {}
        ) {
            Text(text = "bla bla")
        }
    }
}