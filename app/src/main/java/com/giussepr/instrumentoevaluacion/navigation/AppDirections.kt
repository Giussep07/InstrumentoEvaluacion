package com.giussepr.instrumentoevaluacion.navigation

sealed class AppDirections(val route: String) {
    data object SplashScreen : AppDirections("splash_screen")
    data object InformationForm : AppDirections("information_form")
    data object BasicInformationForm : AppDirections("basic_information_form")
    data object QuestionsByRoleForm : AppDirections("questions_by_role_form")
    data object EvaluationScreen: AppDirections("evaluation_screen")
    data object ReportCreatedScreen: AppDirections("report_created_screen")
}
