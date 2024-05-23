package com.giussepr.instrumentoevaluacion.questionsbyrole

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.giussepr.instrumentoevaluacion.R
import com.giussepr.instrumentoevaluacion.navigation.AppDirections
import com.giussepr.instrumentoevaluacion.ui.theme.InstrumentoEvaluacionTheme
import com.giussepr.instrumentoevaluacion.uicomponents.AppLabeledOutlinedTextField
import com.giussepr.instrumentoevaluacion.uicomponents.TextFieldState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuestionsByRoleScreen(navController: NavHostController) {
    val viewModel = hiltViewModel<QuestionByRoleViewModel>()
    val state by viewModel.viewState.collectAsState()

    LaunchedEffect(key1 = Unit) {
        viewModel.onUiEvent(QuestionByRoleViewEvent.LoadRoles)
    }

    LaunchedEffect(state.isFormValid, state.navigationCompleted) {
        if (state.isFormValid && state.navigationCompleted.not()) {
            navController.navigate(AppDirections.EvaluationScreen.route)
            viewModel.onUiEvent(QuestionByRoleViewEvent.CompleteNavigation)
        }
    }

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
                        text = "Preguntas",
                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                },
                navigationIcon = if (navController.previousBackStackEntry != null) {
                    {
                        IconButton(onClick = { navController.navigateUp() }) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = "",
                                tint = MaterialTheme.colorScheme.onPrimary
                            )
                        }
                    }
                } else {
                    {
                        Spacer(Modifier)
                    }
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
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Preguntas para el rol: ${state.role?.name.orEmpty()}",
                style = MaterialTheme.typography.titleLarge,
            )
            state.questions.forEach { question: Question ->
                AppLabeledOutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = question.answer,
                    onValueChange = { value ->
                        viewModel.onUiEvent(QuestionByRoleViewEvent.AnswerChanged(question, value))
                    },
                    placeholder = stringResource(id = R.string.answer),
                    label = question.question,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Done
                    ),
                    textFieldState = question.questionTextFieldState,
                    maxLines = 5
                )
            }
            // Save Button
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    viewModel.onUiEvent(QuestionByRoleViewEvent.SaveClicked)
                }) {
                Text(text = "Guardar")
            }
        }
    }
}

@Preview(device = Devices.TABLET, widthDp = 720, heightDp = 2000)
@Composable
fun QuestionsByRoleScreenPreview() {
    InstrumentoEvaluacionTheme {
        QuestionsByRoleScreen(rememberNavController())
    }
}
