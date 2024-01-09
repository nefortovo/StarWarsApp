package com.example.starWars.components.input

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp

@Composable
fun InputComponent(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit = {}
) {
    Row(
        modifier = modifier
            .border(width = 2.dp, color = Color.Red, shape = RoundedCornerShape(39.dp))
            .background(color = Color.Black, shape = RoundedCornerShape(39.dp))
            .padding(start = 14.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(imageVector = Icons.Default.Search, contentDescription = null,
            tint = Color.White)
        Spacer(modifier = Modifier
            .padding(5.dp))
        BasicTextField(value = value,
            onValueChange = onValueChange,
            cursorBrush = SolidColor(Color.Red),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            singleLine = true,
            textStyle = TextStyle(color = Color.White)
        )
    }
}