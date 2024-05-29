package com.giussepr.instrumentoevaluacion.information

import androidx.lifecycle.ViewModel
import com.giussepr.instrumentoevaluacion.data.InstrumentDataSource
import com.giussepr.instrumentoevaluacion.model.Role
import com.giussepr.instrumentoevaluacion.model.Subject
import com.giussepr.instrumentoevaluacion.uicomponents.TextFieldState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class InformationScreenViewModel @Inject constructor(
    private val instrumentDataSource: InstrumentDataSource
) : ViewModel() {

    var viewState = MutableStateFlow(InformationScreenViewState())
        private set

    private fun getRoles() {
        viewState.update {
            it.copy(
                roles = instrumentDataSource.getRoles(),
                subjects = instrumentDataSource.getSubjects()
            )
        }
    }

    private fun isFormValid(): Boolean {
        var isFormValid = true

        viewState.value.run {
            if (name.isEmpty()) {
                viewState.update { it.copy(nameTextFieldState = TextFieldState.Error("Nombre funcionario es requerido")) }
                isFormValid = false
            }

            if (role == null) {
                viewState.update { it.copy(roleTextFieldState = TextFieldState.Error("Rol es requerido")) }
                isFormValid = false
            }

            if (subject == null) {
                viewState.update { it.copy(subjectTextFieldState = TextFieldState.Error("Tema es requerido")) }
                isFormValid = false
            }

            if (entityName.isEmpty()) {
                viewState.update { it.copy(entityNameTextFieldState = TextFieldState.Error("Nombre entidad es requerido")) }
                isFormValid = false
            }

            if (entityUrl.isEmpty()) {
                viewState.update { it.copy(entityUrlTextFieldState = TextFieldState.Error("URL entidad es requerirdo")) }
                isFormValid = false
            }

            if (entityIdentifier.isEmpty()) {
                viewState.update { it.copy(entityIdentifierTextFieldState = TextFieldState.Error("NIT de la entidad es requerido")) }
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

    fun onUiEvent(uiEvent: InformationScreenUiEvent) {
        when (uiEvent) {
            is InformationScreenUiEvent.GetRoles -> getRoles()

            is InformationScreenUiEvent.OnNameChanged -> {
                viewState.update {
                    it.copy(
                        name = uiEvent.name,
                        nameTextFieldState = TextFieldState.Default
                    )
                }
            }

            is InformationScreenUiEvent.OnSubjectSelected -> {
                viewState.update {
                    it.copy(
                        subject = uiEvent.subject,
                        subjectTextFieldState = TextFieldState.Default
                    )
                }
            }

            is InformationScreenUiEvent.OnEntityNameChanged -> {
                viewState.update {
                    it.copy(
                        entityName = uiEvent.entityName,
                        entityNameTextFieldState = TextFieldState.Default
                    )
                }
            }

            is InformationScreenUiEvent.OnEntityUrlChanged -> {
                viewState.update {
                    it.copy(
                        entityUrl = uiEvent.entityUrl,
                        entityUrlTextFieldState = TextFieldState.Default
                    )
                }
            }

            is InformationScreenUiEvent.OnEntityIdentifierChanged -> {
                viewState.update {
                    it.copy(
                        entityIdentifier = uiEvent.entityIdentifier,
                        entityIdentifierTextFieldState = TextFieldState.Default
                    )
                }
            }

            is InformationScreenUiEvent.OnRoleSelected -> {
                viewState.update {
                    it.copy(
                        role = uiEvent.role,
                        roleTextFieldState = TextFieldState.Default
                    )
                }
            }

            is InformationScreenUiEvent.SaveInformation -> {
                if (isFormValid()) {
                    instrumentDataSource.saveEntityInformation(
                        viewState.value.name,
                        viewState.value.role!!,
                        viewState.value.subject!!,
                        viewState.value.entityName,
                        viewState.value.entityUrl,
                        viewState.value.entityIdentifier
                    )
                }
            }

            is InformationScreenUiEvent.CompleteNavigation -> {
                viewState.update {
                    it.copy(navigationCompleted = true)
                }
            }
        }
    }
}

data class InformationScreenViewState(
    val name: String = "",
    val role: Role? = null,
    val subject: Subject? = null,
    val entityName: String = "",
    val entityUrl: String = "",
    val entityIdentifier: String = "",
    val roles: List<Role> = emptyList(),
    val subjects: List<Subject> = emptyList(),
    val nameTextFieldState: TextFieldState = TextFieldState.Default,
    val roleTextFieldState: TextFieldState = TextFieldState.Default,
    val subjectTextFieldState: TextFieldState = TextFieldState.Default,
    val entityNameTextFieldState: TextFieldState = TextFieldState.Default,
    val entityUrlTextFieldState: TextFieldState = TextFieldState.Default,
    val entityIdentifierTextFieldState: TextFieldState = TextFieldState.Default,
    val isFormValid: Boolean = false,
    val navigationCompleted: Boolean = false
)

sealed class InformationScreenUiEvent {
    data object GetRoles : InformationScreenUiEvent()
    data class OnNameChanged(val name: String) : InformationScreenUiEvent()
    data class OnSubjectSelected(val subject: Subject) : InformationScreenUiEvent()
    data class OnEntityNameChanged(val entityName: String) : InformationScreenUiEvent()
    data class OnEntityUrlChanged(val entityUrl: String) : InformationScreenUiEvent()
    data class OnEntityIdentifierChanged(val entityIdentifier: String) : InformationScreenUiEvent()
    data class OnRoleSelected(val role: Role) : InformationScreenUiEvent()
    data object SaveInformation : InformationScreenUiEvent()
    data object CompleteNavigation : InformationScreenUiEvent()
}
