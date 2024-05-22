package com.giussepr.instrumentoevaluacion.uicomponents

sealed class TextFieldState(val supportingText: String? = null) {
    data object Default : TextFieldState(null)
    data class Error(val errorText: String) : TextFieldState(supportingText = errorText)
}
