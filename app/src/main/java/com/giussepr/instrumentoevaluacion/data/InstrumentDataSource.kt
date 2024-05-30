package com.giussepr.instrumentoevaluacion.data

import com.giussepr.instrumentoevaluacion.model.Role
import com.giussepr.instrumentoevaluacion.model.Subject
import com.giussepr.instrumentoevaluacion.questionsbyrole.Question

class InstrumentDataSource {

    // Entity information
    var name: String = ""
    var role: Role? = null
    var subject: Subject? = null
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
    private val questions: Map<Role, List<Question>> = mapOf(
        Role.CONTROL_INTERNO to listOf(
            Question("1.\tInvestiga la forma como se realiza,n revisiones independientes (por personas diferentes o no vinculadas a un proceso o área que se revisa), de la conveniencia, la adecuación y la eficacia continuas de la gestiónar la seguridad de la información. \n" +
                    "Para esto solicita:\n" +
                    "a)\tEl plan de auditorías del año 2015,,\n" +
                    "b)\tEl resultado de las auditorías del año 2015,\n" +
                    "c)\tLas oportunidades de mejora o cambios en la seguridad de la información identificados.\n"),
            Question("2.\tVerifica si los gerentes aseguran que todos los procedimientos de seguridad dentro de su área de responsabilidad se llevan a cabo correctamente para lograr el cumplimiento de las políticas y estándares de seguridad. "),
            Question("3.\tVerifica la revisión periódica del cumplimiento del centro de cómputo con las políticas y normas de seguridad establecidas. "),
            Question("4.\tVerifica si los sistemas de información son revisados regularmente para asegurar el cumplimiento de las normas de seguridad de la información"),
        ),
        Role.LIDER_DE_PROCESO_1 to listOf(
            Question("1.\tDesarrolla campañas, elaborar folletos y boletines?"),
            Question("2.\tLos planes de toma de conciencia y comunicación, de las políticas de seguridad y privacidad de la información,  están aprobados y documentados, por la alta Dirección?"),
            Question("3.\tVerifica que los nuevos empleados y contratistas son objeto de sensibilización en SI?."),
            Question("4.\tIndaga cada cuanto o con que criterios se actualizan los programas de toma de conciencia?."),
            Question("5.\tVerifica que en las evidencias se puede establecer los asistentes al programa y el tema impartido?."),
            Question("6.\tIncluye en los temas de toma de conciencia los procedimientos básicos de seguridad de la información (tales como el reporte de incidentes de seguridad de la información) y los controles de línea base (tales como la seguridad de las contraseñas, los controles del software malicioso, y los escritorios limpios)."),
            Question("7.\tVerifica de acuerdo a NIST que los funcionarios con roles privilegiados entienden sus responsabilidades y roles."),
        ),
        Role.RESPONSABLE_DE_COMPRAS_Y_ADQUISICIONES to listOf(
            Question("1.\tIndaga y solicita evidencia en una muestra de proveedores seleccionada, como la entidad, hace seguimiento, revisa y audita con regularidad de acuerdo con la política la prestación de servicios de los proveedores y el cumplimiento de los compromisos respecto a la seguridad de la información."),
            Question("2.\tIndaga y evidencia como se gestiónan los cambios en el suministro de servicios por parte de los proveedores, incluido el mantenimiento y la mejora de las políticas, procedimientos y controles de seguridad de la información existentes, teniendo en cuenta la criticidad de la información, sistemas y procesos del negocio involucrados, los incidentes de seguridad de la información y la revaloración de los riesgos."),
        ),
        Role.RESPONSABLE_DE_LA_CONTINUIDAD to listOf(
            Question("1.\tLa Entidad cuenta con un BCP (Bussines Continuity Plan) o DRP (Disaster Recovery Plan)."),
            Question("2.\tDetermina si aplica para procesos críticos solamente o se han incluido otros procesos o por lo menos se ha reconocido la necesidad de ampliarlo a otros procesos (para determinar el nivel de madurez)"),
            Question("3.\tEvalúa si se ha incluido en estos planes y procedimientos los requisitos de seguridad de la información."),
            Question("4.\tSe tiene en cuenta que, en ausencia de una planificación formal de continuidad de negocio y recuperación de desastres, la dirección de seguridad de la información debería suponer que los requisitos de seguridad de la información siguen siendo los mismos en situaciones adversas, en comparación con las condiciones operacionales normales. "),
            Question("5.\tLa organización lleva a cabo un análisis de impacto en el negocio de los aspectos de seguridad de la información, para determinar los requisitos de seguridad de la información aplicables a situaciones adversas. "),
            Question("6.\tSe tiene planes de respuesta a incidentes y recuperación de incidentes."),
        ),
        Role.RESPONSABLE_DE_SI to listOf(
            Question(
                "1.\tSe definen los objetivos, alcance de la política de seguridad de la información"
            ),
            Question(
                "2.\tLa política de seguridad de la información se encuentra alineada con la estrategia y objetivos de la entidad"
            ),
            Question(
                "3.\tSí fue debidamente aprobada y socializada la política de seguridad al interior de la entidad por la alta dirección?"
            ),
            Question(
                "4.\tLos roles y responsabilidades frente a la ciberseguridad han sido establecidos"
            ),
            Question(
                "5.\tLos roles y responsabilidades de seguridad de la información han sido coordinados y alineados con los roles internos y las terceras partes externas "
            ),
            Question(
                "6.\tLos proveedores, clientes, socios, funcionarios, usuarios privilegiados, directores y gerentes (mandos senior), personal de seguridad física, personal de seguridad de la información entienden. sus roles y responsabilidades, Están claros Los roles y responsabilidades para la detección de incidentes."
            ),
            Question(
                "7.\tLa entidad, asigna dispositivos móviles a sus funcionarios o permite que los dispositivos de estos ingresen a la entidad,."
            ),
            Question(
                "8.\tTienen la política y controles para su uso, que protejan la información almacenada o procesada en estos dispositivos y el acceso a servicios de TI desde los mismos."
            ),
            Question(
                "9.\t¿Desarrolla campañas, elaborados folletos y boletines?"
            ),
            Question(
                "10.\tLos planes de toma de conciencia y comunicación, de las políticas de seguridad y privacidad de la información, están aprobados y documentados, por la alta Dirección."
            ),
            Question(
                "11.\t¿Verifica que los nuevos empleados y contratistas son objeto de sensibilización en SI."
            ),
            Question(
                "12.\t¿Indaga cada cuanto o con qué criterios se actualizan los programas de toma de conciencia?"
            ),
            Question(
                "13.\t¿Verifica que en las evidencias se pueden establecer los asistentes al programa y el tema impartido?"
            ),
            Question(
                "14.\tIncluye en los temas de toma de conciencia los procedimientos básicos de seguridad de la información (tales como el reporte de incidentes de seguridad de la información) y los controles de línea base (tales como la seguridad de las contraseñas, los controles del software malicioso, y los escritorios limpios)."
            ),
            Question(
                "15.\tVerifica el acuerdo con NIST, que los funcionarios con roles privilegiados entienden. sus responsabilidades y roles."
            ),
            Question(
                "16.\tSe solicita el inventario de activos de información, revisado y aprobado por la alta Dirección y revisa:\n" +
                        "a)\tÚltima vez que se actualizó\n" +
                        "b)\tQue señale bajo algún criterio la importancia del activo\n" +
                        "c)\tQue señale el propietario del activo\n" +
                        "2.\tInvestiga quien(es) son los encargados(s) de actualizar y revisar el inventario de activos y cada cuanto se realiza, esta revisión.\n"
            ),
            Question(
                "17.\tDe acuerdo con la NIST, se considera como activos el personal, dispositivos, sistemas e instalaciones físicas que permiten a la entidad, cumplir con su misión y objetivos, dada su importancia y riesgos estratégicos."
            ),
            Question(
                "18.\tVerifica si se realiza,n evaluaciones de seguridad técnicas por o bajo la supervisión de personal autorizado, apoyado en herramientas automáticas o con revisiones manuales realiza,das por especialistas. "
            ),
            Question(
                "19.\tSe solicita evidencia de las últimas pruebas realiza,das, sus resultados y seguimiento para asegurar que las brechas de seguridad fueron solucionadas."
            ),
        ),
        Role.RESPONSABLE_DE_TICS to listOf(
            Question("1.\tEl personal o terceros pueden realiza,r actividades de teletrabajo"),
            Question("2.\tEsta la política que indica las condiciones y restricciones para el uso del teletrabajo."),
            Question("3.\tTiene seguridad física existente en el sitio del teletrabajo "),
            Question("4.\tLos requisitos de seguridad de las comunicaciones tienen en cuenta la necesidad de acceso remoto a los sistemas internos de la organización, la sensibilidad de la información a la que se tendrá acceso y que pasará a través del enlace de comunicación y la sensibilidad del sistema interno"),
            Question("5.\tSe solicita las directrices, guías, lineamientos y procedimientos para la gestión de medios removibles, que consideren:\n" +
                    "a)\tSí ya no se requiere, el contenido de cualquier medio reusable que se vaya a retirar de la organización debe remover de forma que no sea recuperable; \n" +
                    "b)\tcuando resulte necesario y práctico, deberá solicitar autorización para retirar los medios de la organización, y debe llevar un registro de dichos retiros con el fin de mantener un rastro de auditoría; \n" +
                    "c)\tsi la confidencialidad o integridad de los datos se consideran importantes, deben usar técnicas criptográficas para proteger los datos que se encuentran en los medios removibles; \n" +
                    "d)\tdeben guardar varias copias de los datos valiosos en medios separadosdos, para reducir aún más el riesgo de daño o pérdida casuales de los datos; \n" +
                    "e)\t sólo deben habilitar unidades de medios removibles si hay una razón de valida asociada a los procesos la Entidad para hacerlo; \n" +
                    "f)\tEn donde hay necesidad de usar medios removibles, debería hacer seguimiento a la transferencia de información a estos medios \n"),
            Question("6.\tSe solicita los procedimientos existentes para garantizar que los medios a desechar o donar, no contienen información confidencial que pueda ser consultada y copiada por personas no autorizadas."),
            Question("7.\tSe solicita los procedimientos para el cumplimiento de los requisitos y contractuales relacionados con los derechos de propiedad intelectual y el uso de productos de software patentados. "),
            Question("8.\tVerifica si la Entidad cuenta con una política publicada sobre el cumplimiento de derechos de propiedad intelectual que defina el uso legal del software y de productos informáticos. Esta política debe estar orientada no solo al software, sino también a documentos gráficos, libros, etc."),
            Question("9.\tSe investiga como se controla que no se instale software ilegal."),
            Question("10.\tIndaga si se tiene un inventario de software instalado y se compara con el número de licencias adquiridas para asegurar que no se incumplen los derechos de propiedad intelectual. "),
            Question("11.\tSe tiene en cuenta los controles que deben existir para asegurar que no se exceda ningún número máximo de usuarios permitido dentro de la licencia."),
        ),
    )
    private var questionsAnswers: List<Question> = listOf()

    // Evaluation
    private var evaluation: Map<String, Int> = mapOf()

    private val subjects = listOf(
        Subject("Revisiones de seguridad de la información"),
    )

    fun saveEntityInformation(
        name: String,
        role: Role,
        subject: Subject?,
        entityName: String,
        entityUrl: String,
        entityIdentifier: String
    ) {
        this.name = name
        this.role = role
        this.subject = subject
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
        return questions[role] ?: emptyList()
    }

    fun saveQuestionAnswers(questions: List<Question>) {
        questionsAnswers = questions
    }

    fun saveEvaluation(evaluation: Map<String, Int>) {
        this.evaluation = evaluation
    }

    fun getInstrumentData(): InstrumentData {
        return InstrumentData(
            entityInformation = EntityInformation(
                name = name,
                role = role,
                subject = subject,
                entityName = entityName,
                entityUrl = entityUrl,
                entityIdentifier = entityIdentifier
            ),
            basicInformation = BasicInformation(
                questionOne = questionOne,
                questionTwo = questionTwo,
                questionThree = questionThree,
                questionFour = questionFour,
                questionFive = questionFive,
                questionSix = questionSix,
                questionSeven = questionSeven,
                questionEight = questionEight,
                questionNine = questionNine,
                questionTen = questionTen,
                questionEleven = questionEleven,
                questionTwelve = questionTwelve,
                questionThirteen = questionThirteen,
                questionFourteen = questionFourteen,
                questionFifteen = questionFifteen,
                questionSixteen = questionSixteen
            ),
            questionsAnswers = questionsAnswers,
            evaluation = evaluation
        )
    }

    fun getRoles(): List<Role> {
        return Role.entries
    }

    fun getSubjects(): List<Subject> {
        return subjects
    }
}
