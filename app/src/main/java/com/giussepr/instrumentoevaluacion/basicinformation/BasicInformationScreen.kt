package com.giussepr.instrumentoevaluacion.basicinformation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
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
import com.giussepr.instrumentoevaluacion.ui.theme.InstrumentoEvaluacionTheme
import com.giussepr.instrumentoevaluacion.uicomponents.AppLabeledOutlinedTextField
import com.giussepr.instrumentoevaluacion.uicomponents.TextFieldState
import com.giussepr.instrumentoevaluacion.uicomponents.selector.AppSelector

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BasicInformationScreen(navController: NavHostController) {
    val viewModel = hiltViewModel<BasicInformationViewModel>()
    val state by viewModel.viewState.collectAsState()

    var isEntityTypeExpanded by remember { mutableStateOf(false) }
    val focusManager = LocalFocusManager.current

    LaunchedEffect(Unit) {
        viewModel.onUiEvent(BasicInformationEvent.LoadEntityTypes)
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
                        text = "Información Básica",
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
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            // Entity Type
            AppSelector(
                modifier = Modifier.fillMaxWidth(),
                label = "Tipo de entidad",
                selectorItem = state.entityType,
                items = state.entityTypes,
                onItemSelected = {
                    viewModel.onUiEvent(BasicInformationEvent.EntityTypeSelected(it as EntityType))
                },
                isError = state.entityTypeTextFieldState is TextFieldState.Error,
                textFieldState = state.entityTypeTextFieldState,
                isExpanded = isEntityTypeExpanded,
                onExpandedChange = { isEntityTypeExpanded = it },
                onDismissRequest = { isEntityTypeExpanded = false }
            )
            // Question One
            AppLabeledOutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = state.questionOne,
                onValueChange = {
                    viewModel.onUiEvent(BasicInformationEvent.QuestionOneChanged(it))
                },
                placeholder = stringResource(R.string.answer),
                label = stringResource(id = R.string.question_one),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(onNext = {
                    focusManager.moveFocus(FocusDirection.Down)
                }),
                textFieldState = state.questionOneTextFieldState,
                maxLines = 2
            )
            // Question Two
            AppLabeledOutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = state.questionTwo,
                onValueChange = {
                    viewModel.onUiEvent(BasicInformationEvent.QuestionTwoChanged(it))
                },
                placeholder = stringResource(R.string.answer),
                label = stringResource(id = R.string.question_two),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(onNext = {
                    focusManager.moveFocus(FocusDirection.Down)
                }),
                textFieldState = state.questionTwoTextFieldState,
                maxLines = 2
            )
            // Question Three
            AppLabeledOutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = state.questionThree,
                onValueChange = {
                    viewModel.onUiEvent(BasicInformationEvent.QuestionThreeChanged(it))
                },
                placeholder = stringResource(R.string.answer),
                label = stringResource(id = R.string.question_three),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(onNext = {
                    focusManager.moveFocus(FocusDirection.Down)
                }),
                textFieldState = state.questionThreeTextFieldState,
                maxLines = 2
            )
            // Question Four
            AppLabeledOutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = state.questionFour,
                onValueChange = {
                    viewModel.onUiEvent(BasicInformationEvent.QuestionFourChanged(it))
                },
                placeholder = stringResource(R.string.answer),
                label = stringResource(id = R.string.question_four),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(onNext = {
                    focusManager.moveFocus(FocusDirection.Down)
                }),
                textFieldState = state.questionFourTextFieldState,
                maxLines = 2
            )
            // Question Five
            AppLabeledOutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = state.questionFive,
                onValueChange = {
                    viewModel.onUiEvent(BasicInformationEvent.QuestionFiveChanged(it))
                },
                placeholder = stringResource(R.string.answer),
                label = stringResource(id = R.string.question_five),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(onNext = {
                    focusManager.moveFocus(FocusDirection.Down)
                }),
                textFieldState = state.questionFiveTextFieldState,
                maxLines = 2
            )
            // Question Six
            AppLabeledOutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = state.questionSix,
                onValueChange = {
                    viewModel.onUiEvent(BasicInformationEvent.QuestionSixChanged(it))
                },
                placeholder = stringResource(R.string.answer),
                label = stringResource(id = R.string.question_six),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(onNext = {
                    focusManager.moveFocus(FocusDirection.Down)
                }),
                textFieldState = state.questionSixTextFieldState,
                maxLines = 2
            )
            // Question Seven
            AppLabeledOutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = state.questionSeven,
                onValueChange = {
                    viewModel.onUiEvent(BasicInformationEvent.QuestionSevenChanged(it))
                },
                placeholder = stringResource(R.string.answer),
                label = stringResource(id = R.string.question_seven),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(onNext = {
                    focusManager.moveFocus(FocusDirection.Down)
                }),
                textFieldState = state.questionSevenTextFieldState,
                maxLines = 2
            )
            // Question Eight
            AppLabeledOutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = state.questionEight,
                onValueChange = {
                    viewModel.onUiEvent(BasicInformationEvent.QuestionEightChanged(it))
                },
                placeholder = stringResource(R.string.answer),
                label = stringResource(id = R.string.question_eight),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(onNext = {
                    focusManager.moveFocus(FocusDirection.Down)
                }),
                textFieldState = state.questionEightTextFieldState,
                maxLines = 2
            )
            // Question Nine
            AppLabeledOutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = state.questionNine,
                onValueChange = {
                    viewModel.onUiEvent(BasicInformationEvent.QuestionNineChanged(it))
                },
                placeholder = stringResource(R.string.answer),
                label = stringResource(id = R.string.question_nine),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(onNext = {
                    focusManager.moveFocus(FocusDirection.Down)
                }),
                textFieldState = state.questionNineTextFieldState,
                maxLines = 2
            )
            // Question Ten
            AppLabeledOutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = state.questionTen,
                onValueChange = {
                    viewModel.onUiEvent(BasicInformationEvent.QuestionTenChanged(it))
                },
                placeholder = stringResource(R.string.answer),
                label = stringResource(id = R.string.question_ten),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions.Default,
                textFieldState = state.questionTenTextFieldState,
                maxLines = 2
            )
            // Question Eleven
            AppLabeledOutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = state.questionEleven,
                onValueChange = {
                    viewModel.onUiEvent(BasicInformationEvent.QuestionElevenChanged(it))
                },
                placeholder = stringResource(R.string.answer),
                label = stringResource(id = R.string.question_eleven),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions.Default,
                textFieldState = state.questionElevenTextFieldState,
                maxLines = 2
            )
            // Question Twelve
            AppLabeledOutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = state.questionTwelve,
                onValueChange = {
                    viewModel.onUiEvent(BasicInformationEvent.QuestionTwelveChanged(it))
                },
                placeholder = stringResource(R.string.answer),
                label = stringResource(id = R.string.question_twelve),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions.Default,
                textFieldState = state.questionTwelveTextFieldState,
                maxLines = 2
            )
            // Question Thirteen
            AppLabeledOutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = state.questionThirteen,
                onValueChange = {
                    viewModel.onUiEvent(BasicInformationEvent.QuestionThirteenChanged(it))
                },
                placeholder = stringResource(R.string.answer),
                label = stringResource(id = R.string.question_thirteen),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions.Default,
                textFieldState = state.questionThirteenTextFieldState,
                maxLines = 2
            )
            // Question Fourteen
            AppLabeledOutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = state.questionFourteen,
                onValueChange = {
                    viewModel.onUiEvent(BasicInformationEvent.QuestionFourteenChanged(it))
                },
                placeholder = stringResource(R.string.answer),
                label = stringResource(id = R.string.question_fourteen),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions.Default,
                textFieldState = state.questionFourteenTextFieldState,
                maxLines = 2
            )
            // Question Fifteen
            AppLabeledOutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = state.questionFifteen,
                onValueChange = {
                    viewModel.onUiEvent(BasicInformationEvent.QuestionFifteenChanged(it))
                },
                placeholder = stringResource(R.string.answer),
                label = stringResource(id = R.string.question_fifteen),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions.Default,
                textFieldState = state.questionFifteenTextFieldState,
                maxLines = 2
            )
            // Question Sixteen
            AppLabeledOutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = state.questionSixteen,
                onValueChange = {
                    viewModel.onUiEvent(BasicInformationEvent.QuestionSixteenChanged(it))
                },
                placeholder = stringResource(R.string.answer),
                label = stringResource(id = R.string.question_sixteen),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions.Default,
                textFieldState = state.questionSixteenTextFieldState,
                maxLines = 2
            )

            // Save Button
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    viewModel.onUiEvent(BasicInformationEvent.SaveBasicInformation)
                }) {
                Text(text = "Guardar")
            }
        }
    }
}

@Preview(device = Devices.TABLET, widthDp = 720, heightDp = 2000)
@Composable
fun BasicInformationScreenPreview() {
    InstrumentoEvaluacionTheme {
        BasicInformationScreen(rememberNavController())
    }
}
