package com.giussepr.instrumentoevaluacion.evaluation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.giussepr.instrumentoevaluacion.api.InstrumentApi
import com.giussepr.instrumentoevaluacion.data.BasicInformation
import com.giussepr.instrumentoevaluacion.data.EntityInformation
import com.giussepr.instrumentoevaluacion.data.InstrumentData
import com.giussepr.instrumentoevaluacion.data.InstrumentDataSource
import com.giussepr.instrumentoevaluacion.uicomponents.TextFieldState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EvaluationViewModel @Inject constructor(
    private val instrumentDataSource: InstrumentDataSource,
    private val instrumentApi: InstrumentApi
) : ViewModel() {

    var viewState = MutableStateFlow(EvaluationViewState())
        private set

    private fun isFormValid(): Boolean {
        var isFormValid = true

        viewState.value.run {
            if (firstItem.isEmpty()) {
                isFormValid = false
                viewState.update {
                    it.copy(firstItemTextFieldState = TextFieldState.Error("Campo requerido"))
                }
            }

            if (secondItem.isEmpty()) {
                isFormValid = false
                viewState.update {
                    it.copy(secondItemTextFieldState = TextFieldState.Error("Campo requerido"))
                }
            }

            if (thirdItem.isEmpty()) {
                isFormValid = false
                viewState.update {
                    it.copy(thirdItemTextFieldState = TextFieldState.Error("Campo requerido"))
                }
            }

            if (fourthItem.isEmpty()) {
                isFormValid = false
                viewState.update {
                    it.copy(fourthItemTextFieldState = TextFieldState.Error("Campo requerido"))
                }
            }

            if (fifthItem.isEmpty()) {
                isFormValid = false
                viewState.update {
                    it.copy(fifthItemTextFieldState = TextFieldState.Error("Campo requerido"))
                }
            }

            if (sixthItem.isEmpty()) {
                isFormValid = false
                viewState.update {
                    it.copy(sixthItemTextFieldState = TextFieldState.Error("Campo requerido"))
                }
            }

            if (seventhItem.isEmpty()) {
                isFormValid = false
                viewState.update {
                    it.copy(seventhItemTextFieldState = TextFieldState.Error("Campo requerido"))
                }
            }

            if (eighthItem.isEmpty()) {
                isFormValid = false
                viewState.update {
                    it.copy(eighthItemTextFieldState = TextFieldState.Error("Campo requerido"))
                }
            }

            if (ninthItem.isEmpty()) {
                isFormValid = false
                viewState.update {
                    it.copy(ninthItemTextFieldState = TextFieldState.Error("Campo requerido"))
                }
            }

            if (tenthItem.isEmpty()) {
                isFormValid = false
                viewState.update {
                    it.copy(tenthItemTextFieldState = TextFieldState.Error("Campo requerido"))
                }
            }

            if (eleventhItem.isEmpty()) {
                isFormValid = false
                viewState.update {
                    it.copy(eleventhItemTextFieldState = TextFieldState.Error("Campo requerido"))
                }
            }

            if (twelfthItem.isEmpty()) {
                isFormValid = false
                viewState.update {
                    it.copy(twelfthItemTextFieldState = TextFieldState.Error("Campo requerido"))
                }
            }

            if (thirteenthItem.isEmpty()) {
                isFormValid = false
                viewState.update {
                    it.copy(thirteenthItemTextFieldState = TextFieldState.Error("Campo requerido"))
                }
            }

            if (fourteenthItem.isEmpty()) {
                isFormValid = false
                viewState.update {
                    it.copy(fourteenthItemTextFieldState = TextFieldState.Error("Campo requerido"))
                }
            }
        }

        return isFormValid
    }

    private fun validateItemInRange(item: String): TextFieldState {
        val itemInt = item.toIntOrNull()

        return if (itemInt != null && itemInt in 0..100) {
            TextFieldState.Default
        } else {
            TextFieldState.Error("El valor debe estar entre 0 y 100")
        }
    }

    fun formHasErrors(): Boolean {
        var hasErrors = false

        viewState.value.run {
            if (firstItemTextFieldState is TextFieldState.Error) {
                hasErrors = true
            }

            if (secondItemTextFieldState is TextFieldState.Error) {
                hasErrors = true
            }

            if (thirdItemTextFieldState is TextFieldState.Error) {
                hasErrors = true
            }

            if (fourthItemTextFieldState is TextFieldState.Error) {
                hasErrors = true
            }

            if (fifthItemTextFieldState is TextFieldState.Error) {
                hasErrors = true
            }

            if (sixthItemTextFieldState is TextFieldState.Error) {
                hasErrors = true
            }

            if (seventhItemTextFieldState is TextFieldState.Error) {
                hasErrors = true
            }

            if (eighthItemTextFieldState is TextFieldState.Error) {
                hasErrors = true
            }

            if (ninthItemTextFieldState is TextFieldState.Error) {
                hasErrors = true
            }

            if (tenthItemTextFieldState is TextFieldState.Error) {
                hasErrors = true
            }

            if (eleventhItemTextFieldState is TextFieldState.Error) {
                hasErrors = true
            }

            if (twelfthItemTextFieldState is TextFieldState.Error) {
                hasErrors = true
            }

            if (thirteenthItemTextFieldState is TextFieldState.Error) {
                hasErrors = true
            }

            if (fourteenthItemTextFieldState is TextFieldState.Error) {
                hasErrors = true
            }
        }

        return hasErrors
    }

    fun onUiEvent(event: EvaluationViewEvent) {
        when (event) {
            is EvaluationViewEvent.FirstEvaluationChanged -> {
                viewState.update {
                    it.copy(
                        firstItem = event.value,
                        firstItemTextFieldState = validateItemInRange(event.value)
                    )
                }
            }

            is EvaluationViewEvent.SecondEvaluationChanged -> {
                viewState.update {
                    it.copy(
                        secondItem = event.value,
                        secondItemTextFieldState = validateItemInRange(event.value)
                    )
                }
            }

            is EvaluationViewEvent.ThirdEvaluationChanged -> {
                viewState.update {
                    it.copy(
                        thirdItem = event.value,
                        thirdItemTextFieldState = validateItemInRange(event.value)
                    )
                }
            }

            is EvaluationViewEvent.FourthEvaluationChanged -> {
                viewState.update {
                    it.copy(
                        fourthItem = event.value,
                        fourthItemTextFieldState = validateItemInRange(event.value)
                    )
                }
            }

            is EvaluationViewEvent.FifthEvaluationChanged -> {
                viewState.update {
                    it.copy(
                        fifthItem = event.value,
                        fifthItemTextFieldState = validateItemInRange(event.value)
                    )
                }
            }

            is EvaluationViewEvent.SixthEvaluationChanged -> {
                viewState.update {
                    it.copy(
                        sixthItem = event.value,
                        sixthItemTextFieldState = validateItemInRange(event.value)
                    )
                }
            }

            is EvaluationViewEvent.SeventhEvaluationChanged -> {
                viewState.update {
                    it.copy(
                        seventhItem = event.value,
                        seventhItemTextFieldState = validateItemInRange(event.value)
                    )
                }
            }

            is EvaluationViewEvent.EighthEvaluationChanged -> {
                viewState.update {
                    it.copy(
                        eighthItem = event.value,
                        eighthItemTextFieldState = validateItemInRange(event.value)
                    )
                }
            }

            is EvaluationViewEvent.NinthEvaluationChanged -> {
                viewState.update {
                    it.copy(
                        ninthItem = event.value,
                        ninthItemTextFieldState = validateItemInRange(event.value)
                    )
                }
            }

            is EvaluationViewEvent.TenthEvaluationChanged -> {
                viewState.update {
                    it.copy(
                        tenthItem = event.value,
                        tenthItemTextFieldState = validateItemInRange(event.value)
                    )
                }
            }

            is EvaluationViewEvent.EleventhEvaluationChanged -> {
                viewState.update {
                    it.copy(
                        eleventhItem = event.value,
                        eleventhItemTextFieldState = validateItemInRange(event.value)
                    )
                }
            }

            is EvaluationViewEvent.TwelfthEvaluationChanged -> {
                viewState.update {
                    it.copy(
                        twelfthItem = event.value,
                        twelfthItemTextFieldState = validateItemInRange(event.value)
                    )
                }
            }

            is EvaluationViewEvent.ThirteenthEvaluationChanged -> {
                viewState.update {
                    it.copy(
                        thirteenthItem = event.value,
                        thirteenthItemTextFieldState = validateItemInRange(event.value)
                    )
                }
            }

            is EvaluationViewEvent.FourteenthEvaluationChanged -> {
                viewState.update {
                    it.copy(
                        fourteenthItem = event.value,
                        fourteenthItemTextFieldState = validateItemInRange(event.value)
                    )
                }
            }

            is EvaluationViewEvent.SaveClicked -> {
                if (isFormValid()) {
                    instrumentDataSource.saveEvaluation(
                        mapOf(
                            "Políticas de seguridad de la información" to (viewState.value.firstItem.toIntOrNull()
                                ?: 0),
                            "Organización de la seguridad de la información" to (viewState.value.secondItem.toIntOrNull()
                                ?: 0),
                            "Seguridad de los recursos humanos" to (viewState.value.thirdItem.toIntOrNull()
                                ?: 0),
                            "Gestión de activos" to (viewState.value.fourthItem.toIntOrNull() ?: 0),
                            "Control de acceso" to (viewState.value.fifthItem.toIntOrNull() ?: 0),
                            "Criptografía" to (viewState.value.sixthItem.toIntOrNull() ?: 0),
                            "Seguridad física y del entorno" to (viewState.value.seventhItem.toIntOrNull()
                                ?: 0),
                            "Seguridad de las operaciones" to (viewState.value.eighthItem.toIntOrNull()
                                ?: 0),
                            "Seguridad de las comunicaciones" to (viewState.value.ninthItem.toIntOrNull()
                                ?: 0),
                            "Adquisición, desarrollo y mantenimiento de sistemas" to (viewState.value.tenthItem.toIntOrNull()
                                ?: 0),
                            "Relaciones con los proveedores" to (viewState.value.eleventhItem.toIntOrNull()
                                ?: 0),
                            "Gestión de incidentes de seguridad de la información" to (viewState.value.twelfthItem.toIntOrNull()
                                ?: 0),
                            "Aspectos de seguridad de la información de la gestión de la continuidad del negocio" to (viewState.value.thirteenthItem.toIntOrNull()
                                ?: 0),
                            "Cumplimiento" to (viewState.value.fourteenthItem.toIntOrNull() ?: 0)
                        )
                    )

                    viewModelScope.launch {
                        instrumentApi.sendInstrumentData(instrumentDataSource.getInstrumentData())
                    }
                }
            }
        }
    }
}

data class EvaluationViewState(
    val firstItem: String = "",
    val secondItem: String = "",
    val thirdItem: String = "",
    val fourthItem: String = "",
    val fifthItem: String = "",
    val sixthItem: String = "",
    val seventhItem: String = "",
    val eighthItem: String = "",
    val ninthItem: String = "",
    val tenthItem: String = "",
    val eleventhItem: String = "",
    val twelfthItem: String = "",
    val thirteenthItem: String = "",
    val fourteenthItem: String = "",
    val firstItemTextFieldState: TextFieldState = TextFieldState.Default,
    val secondItemTextFieldState: TextFieldState = TextFieldState.Default,
    val thirdItemTextFieldState: TextFieldState = TextFieldState.Default,
    val fourthItemTextFieldState: TextFieldState = TextFieldState.Default,
    val fifthItemTextFieldState: TextFieldState = TextFieldState.Default,
    val sixthItemTextFieldState: TextFieldState = TextFieldState.Default,
    val seventhItemTextFieldState: TextFieldState = TextFieldState.Default,
    val eighthItemTextFieldState: TextFieldState = TextFieldState.Default,
    val ninthItemTextFieldState: TextFieldState = TextFieldState.Default,
    val tenthItemTextFieldState: TextFieldState = TextFieldState.Default,
    val eleventhItemTextFieldState: TextFieldState = TextFieldState.Default,
    val twelfthItemTextFieldState: TextFieldState = TextFieldState.Default,
    val thirteenthItemTextFieldState: TextFieldState = TextFieldState.Default,
    val fourteenthItemTextFieldState: TextFieldState = TextFieldState.Default
)

sealed class EvaluationViewEvent {
    data class FirstEvaluationChanged(val value: String) : EvaluationViewEvent()
    data class SecondEvaluationChanged(val value: String) : EvaluationViewEvent()
    data class ThirdEvaluationChanged(val value: String) : EvaluationViewEvent()
    data class FourthEvaluationChanged(val value: String) : EvaluationViewEvent()
    data class FifthEvaluationChanged(val value: String) : EvaluationViewEvent()
    data class SixthEvaluationChanged(val value: String) : EvaluationViewEvent()
    data class SeventhEvaluationChanged(val value: String) : EvaluationViewEvent()
    data class EighthEvaluationChanged(val value: String) : EvaluationViewEvent()
    data class NinthEvaluationChanged(val value: String) : EvaluationViewEvent()
    data class TenthEvaluationChanged(val value: String) : EvaluationViewEvent()
    data class EleventhEvaluationChanged(val value: String) : EvaluationViewEvent()
    data class TwelfthEvaluationChanged(val value: String) : EvaluationViewEvent()
    data class ThirteenthEvaluationChanged(val value: String) : EvaluationViewEvent()
    data class FourteenthEvaluationChanged(val value: String) : EvaluationViewEvent()
    data object SaveClicked : EvaluationViewEvent()
}

