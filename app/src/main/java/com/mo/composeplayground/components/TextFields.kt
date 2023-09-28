package com.mo.composeplayground.components

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.mo.composeplayground.ui.theme.ColorHint

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OutLinedEditText(
    textFieldValue: TextFieldValue = TextFieldValue(),
    icon: ImageVector? = null,
    hint: String = "",
    isPassword: Boolean = false,
    radius: Int = 12
) {

    val shape = RoundedCornerShape(radius.dp)

    var txt by remember {
        mutableStateOf(textFieldValue)
    }
    var showPassword by remember { mutableStateOf(value = false) }

    OutlinedTextField(
        value = txt,
        onValueChange = { newTextFieldValue ->
            txt = newTextFieldValue
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
            if (icon != null){
                Icon(
                    icon!!,
                    contentDescription = null
                )
            }else null
        },
        shape = shape,
        placeholder = { Text(hint, color = ColorHint) },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            containerColor = Color.White,
            focusedBorderColor = Color.Transparent,
            unfocusedBorderColor = Color.Transparent,
            textColor = Color.Black
        ),
        visualTransformation = if (showPassword) {
            VisualTransformation.None
        } else {
            PasswordVisualTransformation()
        },
        trailingIcon = {
            if (isPassword.not()) {
                null
            } else if (showPassword) {
                IconButton(onClick = { showPassword = false }) {
                    Icon(
                        imageVector = Icons.Filled.Visibility,
                        contentDescription = "hide_password"
                    )
                }
            } else {
                IconButton(
                    onClick = { showPassword = true }) {
                    Icon(
                        imageVector = Icons.Filled.VisibilityOff,
                        contentDescription = "hide_password"
                    )
                }
            }
        }
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
