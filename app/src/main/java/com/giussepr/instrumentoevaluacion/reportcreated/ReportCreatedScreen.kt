package com.giussepr.instrumentoevaluacion.reportcreated

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.giussepr.instrumentoevaluacion.R
import com.giussepr.instrumentoevaluacion.navigation.AppDirections
import com.giussepr.instrumentoevaluacion.ui.theme.InstrumentoEvaluacionTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReportCreatedScreen(navController: NavHostController) {

    BackHandler { }

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text(
                        text = "Información Básica",
                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                },
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(16.dp)
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                modifier = Modifier
                    .size(200.dp),
                painter = painterResource(id = R.drawable.ic_report_created),
                contentDescription = null
            )
            Spacer(modifier = Modifier.size(16.dp))
            Text(
                text = "Reporte creado satisfactoriamete",
                style = MaterialTheme.typography.headlineLarge,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.size(16.dp))
            Button(onClick = {
                navController.navigate(AppDirections.InformationForm.route) {
                    popUpTo(AppDirections.SplashScreen.route) {
                        inclusive = true
                    }
                }
            }) {
                Text(text = "Ir a inicio")
            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun ReportCreatedScreenPreview() {
    InstrumentoEvaluacionTheme {
        ReportCreatedScreen(rememberNavController())
    }
}
