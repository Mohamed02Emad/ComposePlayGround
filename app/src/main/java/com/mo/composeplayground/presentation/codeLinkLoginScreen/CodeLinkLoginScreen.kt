package com.mo.composeplayground.presentation.codeLinkLoginScreen

import android.content.Context
import android.widget.Toast
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
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mo.composeplayground.R
import com.mo.composeplayground.components.BigImage
import com.mo.composeplayground.components.OutLinedEditText
import com.mo.composeplayground.components.ShadowButton
import com.mo.composeplayground.ui.theme.ColorPrimary

@Composable
fun LoginScreen(
    context: Context? = null
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        BigImage(painterResource(R.drawable.ic_login_image))
        WelcomeText()
        Spacer(modifier = Modifier.height(20.dp))
        OutLinedEditText(icon = Icons.Outlined.Email, hint = "Email")
        Spacer(modifier = Modifier.height(20.dp))
        OutLinedEditText(icon = Icons.Outlined.Lock, hint = "Password", isPassword = true)
        Spacer(modifier = Modifier.height(10.dp))
        ForgetPasswordText()
        Spacer(modifier = Modifier.height(50.dp))
        LoginButton(context)
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
fun LoginButton(context: Context?) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        ShadowButton(
            background = ColorPrimary,
            radius = 16,
            onClick = {
                context?.let {
                    Toast.makeText(context, "Login Clicked", Toast.LENGTH_SHORT).show()
                }
            }
        ) {
            Text(
                text = "Log in",
                fontSize = 14.sp,
                color = Color.Black,
                modifier = Modifier.padding(horizontal = 30.dp, vertical = 6.dp)
            )
        }
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