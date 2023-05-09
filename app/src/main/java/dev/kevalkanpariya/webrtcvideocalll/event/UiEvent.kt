package dev.kevalkanpariya.webrtcvideocalll.event

sealed class UiEvent: Event() {
    data class ShowSnackBar(val uiText: UiText) : UiEvent()
    data class Navigate(val route: String) : UiEvent()
    object NavigateUp : UiEvent()
    object OnSignIn: UiEvent()
    object OnSignOut: UiEvent()

}