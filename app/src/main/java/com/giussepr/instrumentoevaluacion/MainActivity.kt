package com.giussepr.instrumentoevaluacion

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.giussepr.instrumentoevaluacion.navigation.AppNavHost
import com.giussepr.instrumentoevaluacion.ui.theme.InstrumentoEvaluacionTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InstrumentoEvaluacionTheme {
                AppNavHost(
                    navController = rememberNavController()
                )
            }
        }
    }
}
