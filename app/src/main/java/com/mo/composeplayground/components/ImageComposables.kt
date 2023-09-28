package com.mo.composeplayground.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp


@Composable
fun BigImage(image: Painter) {
    val imageRatio = image.intrinsicSize.width.toFloat() / image.intrinsicSize.height.toFloat()

    Box(
        modifier = Modifier
            .padding(top = 10.dp)
            .padding(horizontal = 70.dp)
            .wrapContentWidth()
            .aspectRatio(imageRatio)

    ) {

        Image(
            painter = image,
            contentDescription = null
        )
    }
}

@Composable
fun SmallImage(image: Painter) {
    val imageRatio = image.intrinsicSize.width.toFloat() / image.intrinsicSize.height.toFloat()
    Box(
        modifier = Modifier
            .padding(horizontal = 10.dp, vertical = 10.dp)
            .wrapContentWidth()
            .aspectRatio(imageRatio)

    ) {
        Image(
            painter = image,
            contentDescription = null
        )
    }
}