package com.giussepr.instrumentoevaluacion.questionsbyrole

import androidx.lifecycle.ViewModel
import com.giussepr.instrumentoevaluacion.data.InstrumentDataSource
import com.giussepr.instrumentoevaluacion.information.Role
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class QuestionByRoleViewModel @Inject constructor(
    private val instrumentDataSource: InstrumentDataSource
) : ViewModel() {

    var viewState = MutableStateFlow(QuestionByRoleViewState())
        private set


    fun onUiEvent(event: QuestionByRoleViewEvent) {
        when (event) {
            is QuestionByRoleViewEvent.LoadRoles -> {
                viewState.value =
                    viewState.value.copy(
                        role = instrumentDataSource.role,
                        questions = instrumentDataSource.getQuestionsByRole()
                    )
            }
        }
    }
}

data class QuestionByRoleViewState(
    val questions: List<Question> = emptyList(),
    val role: Role? = null
)

sealed class QuestionByRoleViewEvent {
    data object LoadRoles : QuestionByRoleViewEvent()
}

data class Question(
    val question: String
)
