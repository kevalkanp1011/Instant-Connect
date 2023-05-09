package dev.kevalkanpariya.webrtcvideocalll.ui.presentations.call

import dev.kevalkanpariya.webrtcvideocalll.event.UiEvent
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow

class CallViewModel {

    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()


    fun onCallEvent(event: CallEvent) {
        when(event) {
            is CallEvent.Call -> {

            }
            is CallEvent.DeclineCall -> {

            }
            is CallEvent.ReceiveCall -> {

            }
        }
    }
}

sealed class CallEvent {
    data class Call(val callId: String): CallEvent()
    object DeclineCall: CallEvent()
    object ReceiveCall: CallEvent()
}

