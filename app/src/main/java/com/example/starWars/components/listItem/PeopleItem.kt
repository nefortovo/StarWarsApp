package com.example.starWars.components.listItem

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.starWars.R
import search.people.models.PeopleFullDataEntity

@Composable
fun PeopleItem(
    modifier: Modifier = Modifier,
    item: PeopleFullDataEntity
) {
    Row(
        modifier = modifier
            .border(width = 2.dp, color = Color.Red, shape = RoundedCornerShape(12.dp))
            .padding(vertical = 12.dp)
            .padding(horizontal = 16.dp)
    ) {
        Image(painter = painterResource(id = R.drawable.img_people), contentDescription = null,
            modifier = Modifier
                .size(90.dp))
        Column(
            modifier = Modifier
                .padding(start = 16.dp)
                .fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = item.name, color = Color.White, fontWeight = FontWeight.Bold,)

            Text(text = stringResource(id = R.string.gender, if (item.gender == "n/a") "Unknown" else item.gender) , color = Color.White,
                modifier = Modifier
                    .padding(top = 8.dp))

            Text(text = stringResource(id = R.string.starships,item.starships.size.toString()), color = Color.White,
                modifier = Modifier
                    .padding(top = 3.dp))

        }
    }
}
