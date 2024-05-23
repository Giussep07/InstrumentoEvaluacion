package com.giussepr.instrumentoevaluacion.basicinformation

import androidx.lifecycle.ViewModel
import com.giussepr.instrumentoevaluacion.data.InstrumentDataSource
import com.giussepr.instrumentoevaluacion.uicomponents.TextFieldState
import com.giussepr.instrumentoevaluacion.uicomponents.selector.SelectorItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class BasicInformationViewModel @Inject constructor(
    private val instrumentDataSource: InstrumentDataSource
) : ViewModel() {

    var viewState = MutableStateFlow(BasicInformationViewState())
        private set

    private fun loadEntityTypes() {
        val entityTypes = listOf(
            EntityType("Privada"),
            EntityType("Pública"),
            EntityType("Mixta"),
        )
        viewState.value = viewState.value.copy(entityTypes = entityTypes)
    }

    private fun isFormValid(): Boolean {
        var isFormValid = true

        viewState.value.run {
            if (entityType == null) {
                viewState.value =
                    viewState.value.copy(entityTypeTextFieldState = TextFieldState.Error("Tipo de entidad es requerido"))
                isFormValid = false
            }

            if (questionOne.isEmpty()) {
                viewState.value =
                    viewState.value.copy(questionOneTextFieldState = TextFieldState.Error("Pregunta es requerida"))
                isFormValid = false
            }

            if (questionTwo.isEmpty()) {
                viewState.value =
                    viewState.value.copy(questionTwoTextFieldState = TextFieldState.Error("Pregunta es requerida"))
                isFormValid = false
            }

            if (questionThree.isEmpty()) {
                viewState.value =
                    viewState.value.copy(questionThreeTextFieldState = TextFieldState.Error("Pregunta es requerida"))
                isFormValid = false
            }

            if (questionFour.isEmpty()) {
                viewState.value =
                    viewState.value.copy(questionFourTextFieldState = TextFieldState.Error("Pregunta es requerida"))
                isFormValid = false
            }

            if (questionFive.isEmpty()) {
                viewState.value =
                    viewState.value.copy(questionFiveTextFieldState = TextFieldState.Error("Pregunta es requerida"))
                isFormValid = false
            }

            if (questionSix.isEmpty()) {
                viewState.value =
                    viewState.value.copy(questionSixTextFieldState = TextFieldState.Error("Pregunta es requerida"))
                isFormValid = false
            }

            if (questionSeven.isEmpty()) {
                viewState.value =
                    viewState.value.copy(questionSevenTextFieldState = TextFieldState.Error("Pregunta es requerida"))
                isFormValid = false
            }

            if (questionEight.isEmpty()) {
                viewState.value =
                    viewState.value.copy(questionEightTextFieldState = TextFieldState.Error("Pregunta es requerida"))
                isFormValid = false
            }

            if (questionNine.isEmpty()) {
                viewState.value =
                    viewState.value.copy(questionNineTextFieldState = TextFieldState.Error("Pregunta es requerida"))
                isFormValid = false
            }

            if (questionTen.isEmpty()) {
                viewState.value =
                    viewState.value.copy(questionTenTextFieldState = TextFieldState.Error("Pregunta es requerida"))
                isFormValid = false
            }

            if (questionEleven.isEmpty()) {
                viewState
                    .value =
                    viewState.value.copy(questionElevenTextFieldState = TextFieldState.Error("Pregunta es requerida"))
                isFormValid = false
            }

            if (questionTwelve.isEmpty()) {
                viewState
                    .value =
                    viewState.value.copy(questionTwelveTextFieldState = TextFieldState.Error("Pregunta es requerida"))
                isFormValid = false
            }

            if (questionThirteen.isEmpty()) {
                viewState
                    .value =
                    viewState.value.copy(questionThirteenTextFieldState = TextFieldState.Error("Pregunta es requerida"))
                isFormValid = false
            }

            if (questionFourteen.isEmpty()) {
                viewState
                    .value =
                    viewState.value.copy(questionFourteenTextFieldState = TextFieldState.Error("Pregunta es requerida"))
                isFormValid = false
            }

            if (questionFifteen.isEmpty()) {
                viewState
                    .value =
                    viewState.value.copy(questionFifteenTextFieldState = TextFieldState.Error("Pregunta es requerida"))
                isFormValid = false
            }

            if (questionSixteen.isEmpty()) {
                viewState
                    .value =
                    viewState.value.copy(questionSixteenTextFieldState = TextFieldState.Error("Pregunta es requerida"))
                isFormValid = false
            }

        }

        viewState.update {
            it.copy(
                isFormValid = isFormValid,
                navigationCompleted = false
            )
        }

        return isFormValid
    }

    fun onUiEvent(event: BasicInformationEvent) {
        when (event) {
            is BasicInformationEvent.LoadEntityTypes -> loadEntityTypes()

            is BasicInformationEvent.EntityTypeSelected -> {
                viewState.value = viewState.value.copy(
                    entityType = event.entityType,
                    entityTypeTextFieldState = TextFieldState.Default
                )
            }

            is BasicInformationEvent.QuestionOneChanged -> {
                viewState.value = viewState.value.copy(
                    questionOne = event.questionOne,
                    questionOneTextFieldState = TextFieldState.Default
                )
            }

            is BasicInformationEvent.QuestionTwoChanged -> {
                viewState.value = viewState.value.copy(
                    questionTwo = event.questionTwo,
                    questionTwoTextFieldState = TextFieldState.Default
                )
            }

            is BasicInformationEvent.QuestionThreeChanged -> {
                viewState.value = viewState.value.copy(
                    questionThree = event.questionThree,
                    questionThreeTextFieldState = TextFieldState.Default
                )
            }

            is BasicInformationEvent.QuestionFourChanged -> {
                viewState.value = viewState.value.copy(
                    questionFour = event.questionFour,
                    questionFourTextFieldState = TextFieldState.Default
                )
            }

            is BasicInformationEvent.QuestionFiveChanged -> {
                viewState.value = viewState.value.copy(
                    questionFive = event.questionFive,
                    questionFiveTextFieldState = TextFieldState.Default
                )
            }

            is BasicInformationEvent.QuestionSixChanged -> {
                viewState.value = viewState.value.copy(
                    questionSix = event.questionSix,
                    questionSixTextFieldState = TextFieldState.Default
                )
            }

            is BasicInformationEvent.QuestionSevenChanged -> {
                viewState.value = viewState.value.copy(
                    questionSeven = event.questionSeven,
                    questionSevenTextFieldState = TextFieldState.Default
                )
            }

            is BasicInformationEvent.QuestionEightChanged -> {
                viewState.value = viewState.value.copy(
                    questionEight = event.questionEight,
                    questionEightTextFieldState = TextFieldState.Default
                )
            }

            is BasicInformationEvent.QuestionNineChanged -> {
                viewState.value = viewState.value.copy(
                    questionNine = event.questionNine,
                    questionNineTextFieldState = TextFieldState.Default
                )
            }

            is BasicInformationEvent.QuestionTenChanged -> {
                viewState.value = viewState.value.copy(
                    questionTen = event.questionTen,
                    questionTenTextFieldState = TextFieldState.Default
                )
            }

            is BasicInformationEvent.QuestionElevenChanged -> {
                viewState.value = viewState.value.copy(
                    questionEleven = event.questionEleven,
                    questionElevenTextFieldState = TextFieldState.Default
                )
            }

            is BasicInformationEvent.QuestionTwelveChanged -> {
                viewState.value = viewState.value.copy(
                    questionTwelve = event.questionTwelve,
                    questionTwelveTextFieldState = TextFieldState.Default
                )
            }

            is BasicInformationEvent.QuestionThirteenChanged -> {
                viewState.value = viewState.value.copy(
                    questionThirteen = event.questionThirteen,
                    questionThirteenTextFieldState = TextFieldState.Default
                )
            }

            is BasicInformationEvent.QuestionFourteenChanged -> {
                viewState.value = viewState.value.copy(
                    questionFourteen = event.questionFourteen,
                    questionFourteenTextFieldState = TextFieldState.Default
                )
            }

            is BasicInformationEvent.QuestionFifteenChanged -> {
                viewState.value = viewState.value.copy(
                    questionFifteen = event.questionFifteen,
                    questionFifteenTextFieldState = TextFieldState.Default
                )
            }

            is BasicInformationEvent.QuestionSixteenChanged -> {
                viewState.value = viewState.value.copy(
                    questionSixteen = event.questionSixteen,
                    questionSixteenTextFieldState = TextFieldState.Default
                )
            }

            is BasicInformationEvent.SaveBasicInformation -> {
                if (isFormValid()) {
                    instrumentDataSource.saveBasicInformation(
                        viewState.value.questionOne,
                        viewState.value.questionTwo,
                        viewState.value.questionThree,
                        viewState.value.questionFour,
                        viewState.value.questionFive,
                        viewState.value.questionSix,
                        viewState.value.questionSeven,
                        viewState.value.questionEight,
                        viewState.value.questionNine,
                        viewState.value.questionTen,
                        viewState.value.questionEleven,
                        viewState.value.questionTwelve,
                        viewState.value.questionThirteen,
                        viewState.value.questionFourteen,
                        viewState.value.questionFifteen,
                        viewState.value.questionSixteen
                    )
                }
            }

            is BasicInformationEvent.CompleteNavigation -> {
                viewState.update { it.copy(navigationCompleted = true) }
            }

        }
    }
}

data class BasicInformationViewState(
    val entityType: EntityType? = null,
    val entityTypes: List<EntityType> = emptyList(),
    val entityTypeTextFieldState: TextFieldState = TextFieldState.Default,
    val questionOne: String = "",
    val questionOneTextFieldState: TextFieldState = TextFieldState.Default,
    val questionTwo: String = "",
    val questionTwoTextFieldState: TextFieldState = TextFieldState.Default,
    val questionThree: String = "",
    val questionThreeTextFieldState: TextFieldState = TextFieldState.Default,
    val questionFour: String = "",
    val questionFourTextFieldState: TextFieldState = TextFieldState.Default,
    val questionFive: String = "",
    val questionFiveTextFieldState: TextFieldState = TextFieldState.Default,
    val questionSix: String = "",
    val questionSixTextFieldState: TextFieldState = TextFieldState.Default,
    val questionSeven: String = "",
    val questionSevenTextFieldState: TextFieldState = TextFieldState.Default,
    val questionEight: String = "",
    val questionEightTextFieldState: TextFieldState = TextFieldState.Default,
    val questionNine: String = "",
    val questionNineTextFieldState: TextFieldState = TextFieldState.Default,
    val questionTen: String = "",
    val questionTenTextFieldState: TextFieldState = TextFieldState.Default,
    val questionEleven: String = "",
    val questionElevenTextFieldState: TextFieldState = TextFieldState.Default,
    val questionTwelve: String = "",
    val questionTwelveTextFieldState: TextFieldState = TextFieldState.Default,
    val questionThirteen: String = "",
    val questionThirteenTextFieldState: TextFieldState = TextFieldState.Default,
    val questionFourteen: String = "",
    val questionFourteenTextFieldState: TextFieldState = TextFieldState.Default,
    val questionFifteen: String = "",
    val questionFifteenTextFieldState: TextFieldState = TextFieldState.Default,
    val questionSixteen: String = "",
    val questionSixteenTextFieldState: TextFieldState = TextFieldState.Default,
    val isFormValid: Boolean = false,
    val navigationCompleted: Boolean = false
)

sealed class BasicInformationEvent {
    data object LoadEntityTypes : BasicInformationEvent()
    data class EntityTypeSelected(val entityType: EntityType) : BasicInformationEvent()
    data class QuestionOneChanged(val questionOne: String) : BasicInformationEvent()
    data class QuestionTwoChanged(val questionTwo: String) : BasicInformationEvent()
    data class QuestionThreeChanged(val questionThree: String) : BasicInformationEvent()
    data class QuestionFourChanged(val questionFour: String) : BasicInformationEvent()
    data class QuestionFiveChanged(val questionFive: String) : BasicInformationEvent()
    data class QuestionSixChanged(val questionSix: String) : BasicInformationEvent()
    data class QuestionSevenChanged(val questionSeven: String) : BasicInformationEvent()
    data class QuestionEightChanged(val questionEight: String) : BasicInformationEvent()
    data class QuestionNineChanged(val questionNine: String) : BasicInformationEvent()
    data class QuestionTenChanged(val questionTen: String) : BasicInformationEvent()
    data class QuestionElevenChanged(val questionEleven: String) : BasicInformationEvent()
    data class QuestionTwelveChanged(val questionTwelve: String) : BasicInformationEvent()
    data class QuestionThirteenChanged(val questionThirteen: String) : BasicInformationEvent()
    data class QuestionFourteenChanged(val questionFourteen: String) : BasicInformationEvent()
    data class QuestionFifteenChanged(val questionFifteen: String) : BasicInformationEvent()
    data class QuestionSixteenChanged(val questionSixteen: String) : BasicInformationEvent()
    data object SaveBasicInformation : BasicInformationEvent()
    data object CompleteNavigation : BasicInformationEvent()
}

data class EntityType(
    val name: String
) : SelectorItem {
    override val text: String
        get() = name
}
