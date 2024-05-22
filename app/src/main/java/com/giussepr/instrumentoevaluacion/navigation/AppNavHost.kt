package com.giussepr.instrumentoevaluacion.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.giussepr.instrumentoevaluacion.basicinformation.BasicInformationScreen
import com.giussepr.instrumentoevaluacion.information.InformationFormScreen
import com.giussepr.instrumentoevaluacion.questionsbyrole.QuestionsByRoleScreen
import com.giussepr.instrumentoevaluacion.splash.SplashScreen

@Composable
fun AppNavHost(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = AppDirections.SplashScreen.route
    ) {
        composable(AppDirections.SplashScreen.route) {
            SplashScreen(navController = navController)
        }

        composable(AppDirections.InformationForm.route) {
            InformationFormScreen(navController = navController)
        }

        composable(AppDirections.BasicInformationForm.route) {
            BasicInformationScreen(navController = navController)
        }

        composable(AppDirections.QuestionsByRoleForm.route) {
            QuestionsByRoleScreen(navController = navController)
        }
    }
}
