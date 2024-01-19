package com.example.starWars.screens.people

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.starWars.screens.people.model.PeopleUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import entity.Entity
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import search.people.interactors.PeopleInteractor
import javax.inject.Inject

@HiltViewModel
class PeopleViewModel @Inject constructor(
    private val peopleInteractor: PeopleInteractor
): ViewModel() {
    private val _peopleUIState = MutableStateFlow(PeopleUIState())
    val peopleUIState = _peopleUIState.asStateFlow()
    suspend fun getPeopleData(name: String){
        viewModelScope.launch {
            when(val resp = peopleInteractor.getPeople(name)){
                is Entity.Success ->{
                    _peopleUIState.update {curr ->
                        curr.copy(
                            peopleData = resp.data.getOrNull(0)
                        )
                    }
                }
                is Entity.Error ->{
                    Log.d("Request", "Request Error")
                }
            }
        }
    }
}