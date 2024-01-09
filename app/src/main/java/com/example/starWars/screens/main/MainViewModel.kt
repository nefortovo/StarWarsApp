package com.example.starWars.screens.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import search.people.interactors.PeopleInteractor
import search.people.models.PeopleFullDataEntity
import javax.inject.Inject

@OptIn(FlowPreview::class)
@HiltViewModel
class MainViewModel @Inject constructor(
    private val peopleInteractor: PeopleInteractor
) : ViewModel() {
    private val _mainUIState = MutableStateFlow(MainUIState())
    val mainUIState = _mainUIState.asStateFlow()


//    private val _newSearchObject: MutableStateFlow<String> = MutableStateFlow("")
//    val newSearchObject = _newSearchObject.asStateFlow()

    private var _peopleList: Flow<PagingData<PeopleFullDataEntity>> = flowOf(PagingData.empty())
    val peopleList: Flow<PagingData<PeopleFullDataEntity>> =
        _peopleList.cachedIn(viewModelScope)

//    init {
//        viewModelScope.launch {
//            _newSearchObject.filter { it.length > 2 }
//                .debounce(1500)
//                .collectLatest {  }
//        }
//    }

    fun searchStarObject(newSearchObject: String) {
        viewModelScope.launch {
            _peopleList = peopleInteractor.searchPeoplePagingData(newSearchObject)
        }
    }

    fun changeSearch(newSearchObject: String){
        _mainUIState.update {curr ->
            curr.copy(
                search = newSearchObject
            )
        }
        if (newSearchObject.length >= 2) {
            searchStarObject(newSearchObject)
        }
    }
}