package com.mo.composeplayground.presentation.codeLinkLoginScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mo.composeplayground.R
import com.mo.composeplayground.components.ShadowButton
import com.mo.composeplayground.ui.theme.ColorHint
import com.mo.composeplayground.ui.theme.ColorPrimary



@Composable
fun LoginScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        BigImage(painterResource(R.drawable.ic_login_image))
        WelcomeText()
        Spacer(modifier = Modifier.height(20.dp))
        OutLinedEditText(icon = Icons.Outlined.Email , "Email")
        Spacer(modifier = Modifier.height(20.dp))
        OutLinedEditText(icon = Icons.Outlined.Lock , "Password")
        Spacer(modifier = Modifier.height(10.dp))
        ForgetPasswordText()
        Spacer(modifier = Modifier.height(50.dp))
        LoginButton()
        Spacer(modifier = Modifier.height(50.dp))
        SignUpText()
    }
}

@Composable
fun SignUpText() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Don’t have an account?",
            color = Color.Black,
            fontSize = 12.sp
        )
        Text(
            text = "Sign Up",
            fontSize = 14.sp,
            color = ColorPrimary,
            modifier = Modifier.padding(start = 4.dp)
        )
    }
}

@Composable
fun LoginButton() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        ShadowButton(
            background = ColorPrimary,
            radius = 16,
            onClick = { /*TODO*/ }
        ) {
            Text(
                text = "Log in",
                fontSize = 16.sp,
                color = Color.Black,
                modifier = Modifier.padding(horizontal = 24.dp, vertical = 4.dp)
            )
        }
    }
}

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

@Composable
fun WelcomeText() {
    Text(
        text = "Welcome Back!",
        fontSize = 18.sp,
        color = Color.Black,
        modifier = Modifier
            .padding(top = 10.dp)
            .padding(horizontal = 16.dp)
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditText(icon: ImageVector, hint: String = "") {
    val shape = RoundedCornerShape(20.dp)

    BasicTextField(
        value = "",
        onValueChange = {},
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth()
            .height(55.dp)
            .clip(shape)
            .shadow(
                elevation = 2.dp,
                shape = shape
            )
            .padding(all = 2.dp)
            .clip(shape),
        visualTransformation = VisualTransformation.None,
        interactionSource = MutableInteractionSource(),
        singleLine = true,

        ) { innerTextField ->
        TextFieldDefaults.TextFieldDecorationBox(
            value = "",
            visualTransformation = VisualTransformation.None,
            innerTextField = innerTextField,
            singleLine = true,
            enabled = true,
            interactionSource = MutableInteractionSource(),
            contentPadding = PaddingValues(0.dp),
            leadingIcon = {
                Icon(
                    imageVector = icon,
                    contentDescription = null
                )
            },
            placeholder = { Text(hint , color = Color.Gray) },
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            )
        )
    }

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OutLinedEditText(icon: ImageVector, hint: String = "") {

    val shape = RoundedCornerShape(12.dp)

    var txt by remember {
        mutableStateOf(TextFieldValue())
    }

    OutlinedTextField(
        value = txt,
        onValueChange = {textFieldValue ->
          txt = textFieldValue
        },
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth()
            .height(55.dp)
            //  .clip(shape)
            .shadow(
                elevation = 2.dp,
                shape = shape
            ),
        leadingIcon = {
            Icon(
                icon,
                contentDescription = null
            )
        },
        shape = shape,
        placeholder = { Text(hint , color = ColorHint) },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            containerColor = Color.White,
            focusedBorderColor = Color.Transparent,
            unfocusedBorderColor = Color.Transparent,
            textColor = Color.Black
        )

    )

}


@Composable
fun ForgetPasswordText() {
    Text(
        text = "forget password?",
        fontSize = 12.sp,
        color = Color.Black,
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth(),
        textAlign = TextAlign.End
    )
}



@Preview(showBackground = true)
@Composable
fun Preview() {
    LoginScreen()
}