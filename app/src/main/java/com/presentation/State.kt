package com.presentation

sealed class State {
    object Success:State()
    object Loading:State()
    data class Error(var message:String):State()
}
