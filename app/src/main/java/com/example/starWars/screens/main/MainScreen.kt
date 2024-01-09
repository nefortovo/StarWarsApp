package com.example.starWars.screens.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.example.starWars.R
import com.example.starWars.components.input.InputComponent

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    viewModel: MainViewModel = hiltViewModel(),
) {
    val mainUiState by viewModel.mainUIState.collectAsState()

    val peopleList = viewModel.peopleList.collectAsLazyPagingItems()

    var isMain by remember{
        mutableStateOf(true)
    }

    Column(
        modifier = modifier
            .background(color = Color.Black),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Text(text = stringResource(id = R.string.main_page),
                color = Color.White,
                modifier = Modifier
                    .clickable { isMain = !isMain },
                fontSize = if (isMain) 18.sp else 16.sp,
                fontWeight = if (isMain) FontWeight.Bold else FontWeight.Normal
                )
            Text(text = stringResource(id = R.string.favorite_page),
                color = Color.White,
                modifier = Modifier
                    .clickable { isMain = !isMain },
                fontSize = if (!isMain) 18.sp else 16.sp,
                fontWeight = if (!isMain) FontWeight.Bold else FontWeight.Normal)
        }

        Column(
            modifier = Modifier
                .padding(top = 28.dp)
                .fillMaxWidth(),
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                if (isMain){
                    Image(painter = painterResource(id = R.drawable.yoda_main),
                        contentDescription = null,
                                modifier = Modifier
                                    .width(174.dp)
                                    .height(105.dp))
                    Text(text = stringResource(id = R.string.main_text),
                        color = Color.White,
                        modifier = Modifier,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold)

                }else {
                    Image(painter = painterResource(id = R.drawable.yoda_favorite),
                        contentDescription = null,
                        modifier = Modifier
                            .width(174.dp)
                            .height(105.dp))
                    Text(text = stringResource(id = R.string.favorite_text),
                        color = Color.White,
                        modifier = Modifier,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold)
                }

            }
            InputComponent(
                value = mainUiState.search,
                onValueChange = { viewModel.changeSearch(it) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 23.dp)
            )
            LazyColumn(
                modifier = Modifier
                    .padding(top = 20.dp)
            ){
                items(peopleList){ it ->
                    it?.let {
                        Text(text = it.name, color = Color.White)
                    }
                }
            }
        }
    }   
}