package com.presentation

import androidx.lifecycle.ViewModel
import com.domain.GetUsefulActivityUseCase
import com.entity.UsefulActivity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
@HiltViewModel
class MainViewModel(useCase: GetUsefulActivityUseCase) : ViewModel() {

    var useCase = useCase
    var _state = MutableStateFlow<State>(State.Success(useCase.execute()))
    var state = _state.asSharedFlow()

    suspend fun reloadUsefulActivity(){
        this._state.value = State.Loading
        delay(1000)
        this._state.value =State.Success(useCase.execute())
    }
}