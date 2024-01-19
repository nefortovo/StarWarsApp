package com.example.starWars.screens.people

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.starWars.R

@Composable
fun PeopleScreen(
    modifier: Modifier = Modifier,
    name: String,
    viewModel: PeopleViewModel = hiltViewModel(),
    onBack: () -> Unit = {}
) {
    val peopleUIState by viewModel.peopleUIState.collectAsState()

    LaunchedEffect(Unit){
        viewModel.getPeopleData(name)
    }

    Column(
        modifier = modifier
            .background(Color.Black)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(imageVector = Icons.Default.ArrowBackIos,
                contentDescription = null,
                tint = Color.Red,
                modifier = Modifier
                    .clickable { onBack() })
            Icon(imageVector = Icons.Default.Share,
                contentDescription = null,
                tint = Color.Red,
                modifier = Modifier
                    .clickable { onBack() })
        }
        Image(painter = painterResource(id = R.drawable.img_people), contentDescription = null,
            modifier = Modifier
                .border(2.dp, Color.Red, shape = RoundedCornerShape(12.dp))
                .fillMaxWidth())
        Column(
            modifier = Modifier
                .padding(top = 20.dp)
        ) {
            Text(text = peopleUIState.peopleData?.name ?: "UNKNOWN", color= Color.White, fontWeight = FontWeight.Bold)
            Text(text = peopleUIState.peopleData?.gender ?: "UNKNOWN", color= Color.White, fontWeight = FontWeight.SemiBold)
        }

    }
}