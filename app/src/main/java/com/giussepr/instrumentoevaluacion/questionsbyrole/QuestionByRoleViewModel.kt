package com.giussepr.instrumentoevaluacion.questionsbyrole

import androidx.lifecycle.ViewModel
import com.giussepr.instrumentoevaluacion.data.InstrumentDataSource
import com.giussepr.instrumentoevaluacion.model.Role
import com.giussepr.instrumentoevaluacion.uicomponents.TextFieldState
import com.giussepr.instrumentoevaluacion.uicomponents.selector.SelectorItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class QuestionByRoleViewModel @Inject constructor(
    private val instrumentDataSource: InstrumentDataSource
) : ViewModel() {

    var viewState = MutableStateFlow(QuestionByRoleViewState())
        private set

    private fun isFormValid(): Boolean {
        var isFormValid = true

        val questions = viewState.value.questions.map { question ->
            if (question.answer == null) {
                isFormValid = false
                question.copy(questionTextFieldState = TextFieldState.Error("Campo requerido"))
            } else {
                question
            }
        }

        viewState.update {
            it.copy(
                questions = questions.toMutableList(),
                isFormValid = isFormValid,
                navigationCompleted = false
            )
        }

        return isFormValid
    }

    private fun updateAnswer(question: Question, answer: Answer) {
        val updatedQuestions = viewState.value.questions.map {
            if (it.question == question.question) {
                it.copy(answer = answer, questionTextFieldState = TextFieldState.Default)
            } else {
                it
            }
        }

        viewState.value = viewState.value.copy(questions = updatedQuestions.toMutableList())
    }

    fun onUiEvent(event: QuestionByRoleViewEvent) {
        when (event) {
            is QuestionByRoleViewEvent.LoadRoles -> {
                viewState.value =
                    viewState.value.copy(
                        role = instrumentDataSource.role,
                        questions = instrumentDataSource.getQuestionsByRole().toMutableList()
                    )
            }

            is QuestionByRoleViewEvent.AnswerChanged -> {
                updateAnswer(event.question, event.answer)
            }

            is QuestionByRoleViewEvent.SaveClicked -> {
                if (isFormValid()) {
                    instrumentDataSource.saveQuestionAnswers(viewState.value.questions)
                }
            }

            is QuestionByRoleViewEvent.CompleteNavigation -> {
                viewState.update {
                    it.copy(navigationCompleted = true)
                }
            }
        }
    }
}

data class QuestionByRoleViewState(
    var questions: MutableList<Question> = mutableListOf(),
    val role: Role? = null,
    val isFormValid: Boolean = false,
    val navigationCompleted: Boolean = false,
    var possibleAnswers: List<Answer> = listOf(
        Answer("Si"),
        Answer("No")
    )
)

sealed class QuestionByRoleViewEvent {
    data object LoadRoles : QuestionByRoleViewEvent()
    data class AnswerChanged(val question: Question, val answer: Answer) : QuestionByRoleViewEvent()
    data object SaveClicked : QuestionByRoleViewEvent()
    data object CompleteNavigation : QuestionByRoleViewEvent()
}

data class Question(
    val question: String,
    var answer: Answer? = null,
    var questionTextFieldState: TextFieldState = TextFieldState.Default,
)

data class Answer(
    val answer: String
) : SelectorItem {
    override val text: String
        get() = answer
}
