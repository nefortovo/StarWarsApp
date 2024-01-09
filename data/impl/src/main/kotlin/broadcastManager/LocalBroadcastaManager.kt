package broadcastManager

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

object LocalBroadcastManager {
    internal val _error: MutableStateFlow<ErrorStatus> = MutableStateFlow(ErrorStatus.Default)
    val error: StateFlow<ErrorStatus> = _error.asStateFlow()
    fun clear(){
        _error.value = ErrorStatus.Default
    }
}

sealed class ErrorStatus(
    open val message: String,
){
    data class Authentication(
        override val message: String,
    ): ErrorStatus(message)

    data class Network(
        override val message: String,
    ): ErrorStatus(message)

    object Default: ErrorStatus("")
}