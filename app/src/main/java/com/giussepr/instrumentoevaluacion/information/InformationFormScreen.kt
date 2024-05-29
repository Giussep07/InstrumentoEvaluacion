package com.giussepr.instrumentoevaluacion.information

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.giussepr.instrumentoevaluacion.model.Role
import com.giussepr.instrumentoevaluacion.model.Subject
import com.giussepr.instrumentoevaluacion.navigation.AppDirections
import com.giussepr.instrumentoevaluacion.ui.theme.InstrumentoEvaluacionTheme
import com.giussepr.instrumentoevaluacion.uicomponents.AppOutlinedTextField
import com.giussepr.instrumentoevaluacion.uicomponents.TextFieldState
import com.giussepr.instrumentoevaluacion.uicomponents.selector.AppSelector

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InformationFormScreen(navController: NavHostController) {
    val viewModel = hiltViewModel<InformationScreenViewModel>()
    val state by viewModel.viewState.collectAsState()

    var isRoleExpanded by remember { mutableStateOf(false) }
    var isSubjectExpanded by remember { mutableStateOf(false) }
    val focusManager = LocalFocusManager.current

    LaunchedEffect(Unit) {
        viewModel.onUiEvent(InformationScreenUiEvent.GetRoles)
    }

    LaunchedEffect(state.isFormValid, state.navigationCompleted) {
        if (state.isFormValid && state.navigationCompleted.not()) {
            navController.navigate(AppDirections.BasicInformationForm.route)
            viewModel.onUiEvent(InformationScreenUiEvent.CompleteNavigation)
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
                        text = "Información de la entidad",
                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Name
            AppOutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = state.name,
                onValueChange = {
                    viewModel.onUiEvent(InformationScreenUiEvent.OnNameChanged(it))
                },
                placeholder = "Nombre funcionario",
                label = "Nombre funcionario",
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(onNext = {
                    focusManager.moveFocus(FocusDirection.Down)
                    isRoleExpanded = true
                }),
                textFieldState = state.nameTextFieldState,
                maxLength = 50
            )
            // Role
            AppSelector(
                modifier = Modifier.fillMaxWidth(),
                label = "Rol",
                selectorItem = state.role,
                items = state.roles,
                onItemSelected = {
                    viewModel.onUiEvent(InformationScreenUiEvent.OnRoleSelected(it as Role))
                },
                isError = state.roleTextFieldState is TextFieldState.Error,
                textFieldState = state.roleTextFieldState,
                isExpanded = isRoleExpanded,
                onExpandedChange = { isRoleExpanded = it },
                onDismissRequest = { isRoleExpanded = false }
            )
            // Area
            AppSelector(
                modifier = Modifier.fillMaxWidth(),
                label = "Tema",
                selectorItem = state.subject,
                items = state.subjects,
                onItemSelected = {
                    viewModel.onUiEvent(InformationScreenUiEvent.OnSubjectSelected(it as Subject))
                },
                isError = state.subjectTextFieldState is TextFieldState.Error,
                textFieldState = state.subjectTextFieldState,
                isExpanded = isSubjectExpanded,
                onExpandedChange = { isSubjectExpanded = it },
                onDismissRequest = { isSubjectExpanded = false }
            )
            // Entity Name
            AppOutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = state.entityName,
                onValueChange = {
                    viewModel.onUiEvent(InformationScreenUiEvent.OnEntityNameChanged(it))
                },
                placeholder = "Nombre entidad",
                label = "Nombre entidad",
                maxLines = 1,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(onNext = { focusManager.moveFocus(FocusDirection.Down) }),
                textFieldState = state.entityNameTextFieldState,
                maxLength = 50
            )
            // Entity URL
            AppOutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = state.entityUrl,
                onValueChange = {
                    viewModel.onUiEvent(InformationScreenUiEvent.OnEntityUrlChanged(it))
                },
                placeholder = "URL entidad",
                label = "URL entidad",
                maxLines = 1,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(onNext = { focusManager.moveFocus(FocusDirection.Down) }),
                textFieldState = state.entityUrlTextFieldState,
                maxLength = 50
            )
            // Entity Identifier
            AppOutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = state.entityIdentifier,
                onValueChange = {
                    viewModel.onUiEvent(InformationScreenUiEvent.OnEntityIdentifierChanged(it))
                },
                placeholder = "NIT de la entidad",
                label = "NIT de la entidad",
                maxLines = 1,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Done
                ),
                textFieldState = state.entityIdentifierTextFieldState,
                maxLength = 10
            )

            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    viewModel.onUiEvent(InformationScreenUiEvent.SaveInformation)
                }) {
                Text(text = "Guardar")
            }
        }
    }
}

@Preview
@Composable
fun InformationFormScreenPreview() {
    InstrumentoEvaluacionTheme {
        InformationFormScreen(navController = rememberNavController())
    }
}
