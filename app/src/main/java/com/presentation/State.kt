package com.presentation

import com.domain.GetUsefulActivityUseCase
import com.entity.UsefulActivity

sealed class State {
    data class Success(var useCaseActivity:UsefulActivity):State()
    object Loading:State()
    data class Error(var message:String):State()
}
