package com.example.designsystem.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.designsystem.Primary
import com.example.designsystem.WhiteColor
import com.example.designsystem.Yekanbakh

@Composable
fun JetButton() {
    Button(
        onClick = {},
        colors = ButtonDefaults.buttonColors(
            contentColor = Primary
        ),
        shape = RoundedCornerShape(8.dp),
        contentPadding = PaddingValues(0.dp),
        modifier = Modifier.width(200.dp).height(50.dp)
    ) {
        Text(
            text = "احسان پیش یار",
            fontFamily = Yekanbakh,
            fontSize = 15.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Center,
            color = WhiteColor
        )
    }
}

@Preview
@Composable
fun Preview_JetButton() {
    JetButton()
}