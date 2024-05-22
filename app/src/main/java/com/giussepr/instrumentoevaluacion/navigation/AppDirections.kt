package com.giussepr.instrumentoevaluacion.navigation

sealed class AppDirections(val route: String) {
    data object SplashScreen : AppDirections("splash_screen")
    data object InformationForm : AppDirections("information_form")
    data object BasicInformationForm : AppDirections("basic_information_form")
}
