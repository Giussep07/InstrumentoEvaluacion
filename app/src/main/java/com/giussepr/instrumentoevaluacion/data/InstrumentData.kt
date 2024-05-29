package com.giussepr.instrumentoevaluacion.data

import com.giussepr.instrumentoevaluacion.model.Role
import com.giussepr.instrumentoevaluacion.model.Subject
import com.giussepr.instrumentoevaluacion.questionsbyrole.Question

data class InstrumentData(
    val entityInformation: EntityInformation,
    val basicInformation: BasicInformation,
    var questionsAnswers: List<Question>,
    val evaluation: Map<String, Int>
)

data class EntityInformation(
    var name: String = "",
    var role: Role? = null,
    var subject: Subject? = null,
    var entityName: String = "",
    var entityUrl: String = "",
    var entityIdentifier: String = "",
)

data class BasicInformation(
    var questionOne: String = "",
    var questionTwo: String = "",
    var questionThree: String = "",
    var questionFour: String = "",
    var questionFive: String = "",
    var questionSix: String = "",
    var questionSeven: String = "",
    var questionEight: String = "",
    var questionNine: String = "",
    var questionTen: String = "",
    var questionEleven: String = "",
    var questionTwelve: String = "",
    var questionThirteen: String = "",
    var questionFourteen: String = "",
    var questionFifteen: String = "",
    var questionSixteen: String = ""
)
