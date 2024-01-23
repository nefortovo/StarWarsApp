package com.example.starWars.screens.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import search.people.interactors.PeopleInteractor
import search.people.models.PeopleFullDataEntity
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val peopleInteractor: PeopleInteractor
) : ViewModel() {
    private val _mainUIState = MutableStateFlow(MainUIState())
    val mainUIState = _mainUIState.asStateFlow()

    private val _searchPeople = MutableStateFlow("")
    val searchPeople = _searchPeople.asStateFlow()

    private var _peopleList: Flow<PagingData<PeopleFullDataEntity>> =
        peopleInteractor.searchPeoplePagingData(_searchPeople.value)
    val peopleList: Flow<PagingData<PeopleFullDataEntity>> = _peopleList.cachedIn(viewModelScope)


    private val _favoritePeople = MutableStateFlow(emptyList<PeopleFullDataEntity>())
    val favoritePeople = _favoritePeople.asStateFlow()


    fun getAllSavedPeople() {
        viewModelScope.launch {
            peopleInteractor.getAllSavedPeople().flowOn(Dispatchers.IO)
                .collect { people ->
                    _favoritePeople.update { people }
                }
        }
    }

    fun saveOrDelete(peopleFullDataEntity: PeopleFullDataEntity) {
        viewModelScope.launch {
            if (peopleFullDataEntity.isFavorite) {
                savePeople(peopleFullDataEntity)
            } else {
                deletePeople(peopleFullDataEntity)
            }
        }
    }

    private suspend fun savePeople(peopleFullDataEntity: PeopleFullDataEntity) {
        peopleInteractor.savePeople(peopleFullDataEntity)
    }

    private suspend fun deletePeople(peopleFullDataEntity: PeopleFullDataEntity) {
        peopleInteractor.deletePeople(peopleFullDataEntity)
    }


    fun changeSearch(newSearchObject: String) {

        _searchPeople.value = newSearchObject

        if (newSearchObject.length >= 2) {
            _searchPeople.value = newSearchObject
        }
    }
}