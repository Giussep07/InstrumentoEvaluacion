package com.giussepr.instrumentoevaluacion.data

import com.giussepr.instrumentoevaluacion.information.Role
import com.giussepr.instrumentoevaluacion.questionsbyrole.Question

class InstrumentDataSource {

    // Entity information
    var name: String = ""
    var role: Role? = null
    var area: String = ""
    var entityName: String = ""
    var entityUrl: String = ""
    var entityIdentifier: String = ""

    // Basic information
    var questionOne: String = ""
    var questionTwo: String = ""
    var questionThree: String = ""
    var questionFour: String = ""
    var questionFive: String = ""
    var questionSix: String = ""
    var questionSeven: String = ""
    var questionEight: String = ""
    var questionNine: String = ""
    var questionTen: String = ""
    var questionEleven: String = ""
    var questionTwelve: String = ""
    var questionThirteen: String = ""
    var questionFourteen: String = ""
    var questionFifteen: String = ""
    var questionSixteen: String = ""

    // Questions by role
    private val questions: Map<String, List<Question>> = mapOf(
        "Control interno" to listOf(
            Question("Pregunta 1")
        ),
        "Gestión humana" to listOf(
            Question("Pregunta 1"),
            Question("Pregunta 2"),
        ),
        "Líder de Proceso 1" to listOf(
            Question("Pregunta 1"),
            Question("Pregunta 2"),
            Question("Pregunta 3"),
        ),
        "Líder de Proceso 2" to listOf(
            Question("Pregunta 1"),
            Question("Pregunta 2"),
            Question("Pregunta 3"),
            Question("Pregunta 4"),
        ),
        "Líder de Proceso 3" to listOf(
            Question("Pregunta 1"),
            Question("Pregunta 2"),
            Question("Pregunta 3"),
            Question("Pregunta 4"),
            Question("Pregunta 5"),
        ),
        "Responsable de compras y adquisiciones" to listOf(
            Question("Pregunta 1"),
            Question("Pregunta 2"),
            Question("Pregunta 3"),
            Question("Pregunta 4"),
            Question("Pregunta 5"),
            Question("Pregunta 6"),
        ),
        "Responsable de la continuidad" to listOf(
            Question("Pregunta 1"),
            Question("Pregunta 2"),
            Question("Pregunta 3"),
            Question("Pregunta 4"),
            Question("Pregunta 5"),
            Question("Pregunta 6"),
            Question("Pregunta 7"),
        ),
        "Responsable de la seguridad física" to listOf(
            Question("Pregunta 1"),
            Question("Pregunta 2"),
            Question("Pregunta 3"),
            Question("Pregunta 4"),
            Question("Pregunta 5"),
            Question("Pregunta 6"),
            Question("Pregunta 7"),
            Question("Pregunta 8"),
        ),
        "Responsable de SI" to listOf(
            Question("Pregunta 1"),
            Question("Pregunta 2"),
            Question("Pregunta 3"),
            Question("Pregunta 4"),
            Question("Pregunta 5"),
            Question("Pregunta 6"),
            Question("Pregunta 7"),
            Question("Pregunta 8"),
            Question("Pregunta 9"),
        ),
        "Responsable de TICs" to listOf(
            Question("Pregunta 1"),
            Question("Pregunta 2"),
            Question("Pregunta 3"),
            Question("Pregunta 4"),
            Question("Pregunta 5"),
            Question("Pregunta 6"),
            Question("Pregunta 7"),
            Question("Pregunta 8"),
            Question("Pregunta 9"),
            Question("Pregunta 10"),
        ),
        "Calidad" to listOf(
            Question("Pregunta 1"),
            Question("Pregunta 2"),
            Question("Pregunta 3"),
            Question("Pregunta 4"),
            Question("Pregunta 5"),
            Question("Pregunta 6"),
            Question("Pregunta 7"),
            Question("Pregunta 8"),
            Question("Pregunta 9"),
            Question("Pregunta 10"),
            Question("Pregunta 11"),
        )
    )

    fun saveEntityInformation(
        name: String,
        role: Role,
        area: String,
        entityName: String,
        entityUrl: String,
        entityIdentifier: String
    ) {
        this.name = name
        this.role = role
        this.area = area
        this.entityName = entityName
        this.entityUrl = entityUrl
        this.entityIdentifier = entityIdentifier
    }

    fun saveBasicInformation(
        questionOne: String,
        questionTwo: String,
        questionThree: String,
        questionFour: String,
        questionFive: String,
        questionSix: String,
        questionSeven: String,
        questionEight: String,
        questionNine: String,
        questionTen: String,
        questionEleven: String,
        questionTwelve: String,
        questionThirteen: String,
        questionFourteen: String,
        questionFifteen: String,
        questionSixteen: String
    ) {
        this.questionOne = questionOne
        this.questionTwo = questionTwo
        this.questionThree = questionThree
        this.questionFour = questionFour
        this.questionFive = questionFive
        this.questionSix = questionSix
        this.questionSeven = questionSeven
        this.questionEight = questionEight
        this.questionNine = questionNine
        this.questionTen = questionTen
        this.questionEleven = questionEleven
        this.questionTwelve = questionTwelve
        this.questionThirteen = questionThirteen
        this.questionFourteen = questionFourteen
        this.questionFifteen = questionFifteen
        this.questionSixteen = questionSixteen
    }

    fun getQuestionsByRole(): List<Question> {
        return questions[role?.name.orEmpty()] ?: emptyList()
    }
}
