package com.giussepr.instrumentoevaluacion.evaluation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.text.isDigitsOnly
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.giussepr.instrumentoevaluacion.navigation.AppDirections
import com.giussepr.instrumentoevaluacion.ui.theme.InstrumentoEvaluacionTheme
import com.giussepr.instrumentoevaluacion.uicomponents.AppOutlinedTextField

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EvaluationScreen(navController: NavHostController) {
    val viewModel = hiltViewModel<EvaluationViewModel>()
    val state by viewModel.viewState.collectAsState()

    val focusManager = LocalFocusManager.current

    LaunchedEffect(state.isFormValid, state.navigationCompleted) {
        if (state.isFormValid && state.navigationCompleted.not()) {
            navController.navigate(AppDirections.ReportCreatedScreen.route)
            viewModel.onUiEvent(EvaluationViewEvent.CompleteNavigation)
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
                        text = "Evaluación",
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
            // First item
            AppOutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = state.firstItem.toString(),
                onValueChange = {
                    if (it.isDigitsOnly()) {
                        viewModel.onUiEvent(
                            EvaluationViewEvent.FirstEvaluationChanged(it)
                        )
                    }
                },
                placeholder = "Políticas de seguridad de la información",
                label = "Políticas de seguridad de la información",
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(onNext = {
                    focusManager.moveFocus(FocusDirection.Down)
                }),
                textFieldState = state.firstItemTextFieldState
            )
            // Second item
            AppOutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = state.secondItem.toString(),
                onValueChange = {
                    if (it.isDigitsOnly()) {
                        viewModel.onUiEvent(
                            EvaluationViewEvent.SecondEvaluationChanged(it)
                        )
                    }
                },
                placeholder = "Organización de la seguridad de la información",
                label = "Organización de la seguridad de la información",
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(onNext = {
                    focusManager.moveFocus(FocusDirection.Down)
                }),
                textFieldState = state.secondItemTextFieldState
            )
            // Third item
            AppOutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = state.thirdItem.toString(),
                onValueChange = {
                    if (it.isDigitsOnly()) {
                        viewModel.onUiEvent(
                            EvaluationViewEvent.ThirdEvaluationChanged(it)
                        )
                    }
                },
                placeholder = "Seguridad de los recursos humanos",
                label = "Seguridad de los recursos humanos",
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(onNext = {
                    focusManager.moveFocus(FocusDirection.Down)
                }),
                textFieldState = state.thirdItemTextFieldState
            )
            // Fourth item
            AppOutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = state.fourthItem.toString(),
                onValueChange = {
                    if (it.isDigitsOnly()) {
                        viewModel.onUiEvent(
                            EvaluationViewEvent.FourthEvaluationChanged(it)
                        )
                    }
                },
                placeholder = "Gestión de activos",
                label = "Gestión de activos",
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(onNext = {
                    focusManager.moveFocus(FocusDirection.Down)
                }),
                textFieldState = state.fourthItemTextFieldState
            )
            // Fifth item
            AppOutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = state.fifthItem.toString(),
                onValueChange = {
                    if (it.isDigitsOnly()) {
                        viewModel.onUiEvent(
                            EvaluationViewEvent.FifthEvaluationChanged(it)
                        )
                    }
                },
                placeholder = "Control de acceso",
                label = "Control de acceso",
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(onNext = {
                    focusManager.moveFocus(FocusDirection.Down)
                }),
                textFieldState = state.fifthItemTextFieldState
            )
            // Sixth item
            AppOutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = state.sixthItem.toString(),
                onValueChange = {
                    if (it.isDigitsOnly()) {
                        viewModel.onUiEvent(
                            EvaluationViewEvent.SixthEvaluationChanged(it)
                        )
                    }
                },
                placeholder = "Criptografía",
                label = "Criptografía",
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(onNext = {
                    focusManager.moveFocus(FocusDirection.Down)
                }),
                textFieldState = state.sixthItemTextFieldState
            )
            // Seventh item
            AppOutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = state.seventhItem.toString(),
                onValueChange = {
                    if (it.isDigitsOnly()) {
                        viewModel.onUiEvent(
                            EvaluationViewEvent.SeventhEvaluationChanged(it)
                        )
                    }
                },
                placeholder = "Seguridad física y del entorno",
                label = "Seguridad física y del entorno",
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(onNext = {
                    focusManager.moveFocus(FocusDirection.Down)
                }),
                textFieldState = state.seventhItemTextFieldState
            )
            // Eighth item
            AppOutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = state.eighthItem.toString(),
                onValueChange = {
                    if (it.isDigitsOnly()) {
                        viewModel.onUiEvent(
                            EvaluationViewEvent.EighthEvaluationChanged(it)
                        )
                    }
                },
                placeholder = "Seguridad de las operaciones",
                label = "Seguridad de las operaciones",
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(onNext = {
                    focusManager.moveFocus(FocusDirection.Down)
                }),
                textFieldState = state.eighthItemTextFieldState
            )
            // Ninth item
            AppOutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = state.ninthItem.toString(),
                onValueChange = {
                    if (it.isDigitsOnly()) {
                        viewModel.onUiEvent(
                            EvaluationViewEvent.NinthEvaluationChanged(it)
                        )
                    }
                },
                placeholder = "Seguridad de las comunicaciones",
                label = "Seguridad de las comunicaciones",
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(onNext = {
                    focusManager.moveFocus(FocusDirection.Down)
                }),
                textFieldState = state.ninthItemTextFieldState
            )
            // Tenth item
            AppOutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = state.tenthItem.toString(),
                onValueChange = {
                    if (it.isDigitsOnly()) {
                        viewModel.onUiEvent(
                            EvaluationViewEvent.TenthEvaluationChanged(it)
                        )
                    }
                },
                placeholder = "Adquisición, desarrollo y mantenimiento de sistemas",
                label = "Adquisición, desarrollo y mantenimiento de sistemas",
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(onNext = {
                    focusManager.moveFocus(FocusDirection.Down)
                }),
                textFieldState = state.tenthItemTextFieldState
            )
            // Eleventh item
            AppOutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = state.eleventhItem.toString(),
                onValueChange = {
                    if (it.isDigitsOnly()) {
                        viewModel.onUiEvent(
                            EvaluationViewEvent.EleventhEvaluationChanged(it)
                        )
                    }
                },
                placeholder = "Relaciones con los proveedores",
                label = "Relaciones con los proveedores",
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(onNext = {
                    focusManager.moveFocus(FocusDirection.Down)
                }),
                textFieldState = state.eleventhItemTextFieldState
            )
            // Twelfth item
            AppOutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = state.twelfthItem.toString(),
                onValueChange = {
                    if (it.isDigitsOnly()) {
                        viewModel.onUiEvent(
                            EvaluationViewEvent.TwelfthEvaluationChanged(it)
                        )
                    }
                },
                placeholder = "Gestión de incidentes de seguridad de la información",
                label = "Gestión de incidentes de seguridad de la información",
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(onNext = {
                    focusManager.moveFocus(FocusDirection.Down)
                }),
                textFieldState = state.twelfthItemTextFieldState
            )
            // Thirteenth item
            AppOutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = state.thirteenthItem.toString(),
                onValueChange = {
                    if (it.isDigitsOnly()) {
                        viewModel.onUiEvent(
                            EvaluationViewEvent.ThirteenthEvaluationChanged(it)
                        )
                    }
                },
                placeholder = "Aspectos de seguridad de la información de la gestión de la continuidad del negocio",
                label = "Aspectos de seguridad de la información de la gestión de la continuidad del negocio",
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(onNext = {
                    focusManager.moveFocus(FocusDirection.Down)
                }),
                textFieldState = state.thirteenthItemTextFieldState
            )
            // Fourteenth item
            AppOutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = state.fourteenthItem,
                onValueChange = {
                    if (it.isDigitsOnly()) {
                        viewModel.onUiEvent(
                            EvaluationViewEvent.FourteenthEvaluationChanged(it)
                        )
                    }
                },
                placeholder = "Cumplimiento",
                label = "Cumplimiento",
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(onDone = {
                    focusManager.clearFocus()
                }),
                textFieldState = state.fourteenthItemTextFieldState
            )
            // Save Button
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    viewModel.onUiEvent(EvaluationViewEvent.SaveClicked)
                },
                enabled = viewModel.formHasErrors().not()
            ) {
                Text(text = "Guardar")
            }
        }
    }
}

@Preview
@Composable
fun EvaluationScreenPreview() {
    InstrumentoEvaluacionTheme {
        EvaluationScreen(navController = rememberNavController())
    }
}


