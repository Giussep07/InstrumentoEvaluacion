package com.giussepr.instrumentoevaluacion.information

import androidx.lifecycle.ViewModel
import com.giussepr.instrumentoevaluacion.data.InstrumentDataSource
import com.giussepr.instrumentoevaluacion.uicomponents.TextFieldState
import com.giussepr.instrumentoevaluacion.uicomponents.selector.SelectorItem
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
        val roles = listOf(
            Role("Control interno", "Control interno description"),
            Role("Gestión humana", "Gestión humana description"),
            Role("Líder de Proceso 1", "Líder de Proceso 1 description"),
            Role("Líder de Proceso 2", "Líder de Proceso 2 description"),
            Role("Líder de Proceso 3", "Líder de Proceso 3 description"),
            Role(
                "Responsable de compras y adquisiciones",
                "Responsable de compras y adquisiciones description"
            ),
            Role("Responsable de la continuidad", "Responsable de la continuidad description"),
            Role(
                "Responsable de la seguridad física",
                "Responsable de la seguridad física description"
            ),
            Role("Responsable de SI", "Responsable de SI description"),
            Role("Responsable de TICs", "Responsable de TICs description"),
            Role("Calidad", "Calidad description"),
        )
        viewState.update {
            it.copy(roles = roles)
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

            if (area.isEmpty()) {
                viewState.update { it.copy(areaTextFieldState = TextFieldState.Error("Area es requerido")) }
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

            is InformationScreenUiEvent.OnAreaChanged -> {
                viewState.update {
                    it.copy(
                        area = uiEvent.area,
                        areaTextFieldState = TextFieldState.Default
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
                        viewState.value.area,
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
    val area: String = "",
    val entityName: String = "",
    val entityUrl: String = "",
    val entityIdentifier: String = "",
    val roles: List<Role> = emptyList(),
    val nameTextFieldState: TextFieldState = TextFieldState.Default,
    val roleTextFieldState: TextFieldState = TextFieldState.Default,
    val areaTextFieldState: TextFieldState = TextFieldState.Default,
    val entityNameTextFieldState: TextFieldState = TextFieldState.Default,
    val entityUrlTextFieldState: TextFieldState = TextFieldState.Default,
    val entityIdentifierTextFieldState: TextFieldState = TextFieldState.Default,
    val isFormValid: Boolean = false,
    val navigationCompleted: Boolean = false
)

sealed class InformationScreenUiEvent {
    data object GetRoles : InformationScreenUiEvent()
    data class OnNameChanged(val name: String) : InformationScreenUiEvent()
    data class OnAreaChanged(val area: String) : InformationScreenUiEvent()
    data class OnEntityNameChanged(val entityName: String) : InformationScreenUiEvent()
    data class OnEntityUrlChanged(val entityUrl: String) : InformationScreenUiEvent()
    data class OnEntityIdentifierChanged(val entityIdentifier: String) : InformationScreenUiEvent()
    data class OnRoleSelected(val role: Role) : InformationScreenUiEvent()
    data object SaveInformation : InformationScreenUiEvent()
    data object CompleteNavigation: InformationScreenUiEvent()
}

data class Role(
    val name: String = "",
    val description: String = ""
) : SelectorItem {
    override val text: String
        get() = name
}
