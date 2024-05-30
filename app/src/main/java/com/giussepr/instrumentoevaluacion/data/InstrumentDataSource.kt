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
            Question(
                "Investigue la forma como se realizan revisiones independientes (por personas diferentes o no vinculadas a un proceso o área que se revisa), de la conveniencia, la adecuación y la eficacia continuas de la  gestionar la seguridad de la información. \n" +
                        "Para esto solicite:\n" +
                        "1) El plan de auditorías del año 2015\n" +
                        "2) El resultado de las auditorías del año 2015\n" +
                        "3) Las oportunidades de mejora o cambios en la seguridad de la información identificados."
            ),
            Question(
                "1) Verifique si los gerentes aseguran que todos los procedimientos de seguridad dentro de su área de responsabilidad se llevan a cabo correctamente para lograr el cumplimiento de las políticas y estándares de seguridad. \n" +
                        "2) Verifique la revisión periódica del cumplimiento del centro de cómputo con  las políticas y normas de seguridad establecidas. \n" +
                        "3) Verifique si los sistemas de información son revisados regularmente para asegurar el cumplimiento de las normas de seguridad de la información."
            )
        ),
        Role.LIDER_DE_PROCESO_1 to listOf(
            Question("a) Desarrolla campañas, elaborar folletos y boletines?"),
            Question("b) Los planes de toma de conciencia y comunicación, de las políticas de seguridad y privacidad de la información,  están aprobados y documentados, por la alta Dirección?"),
            Question("c) Verifica que los nuevos empleados y contratistas son objeto de sensibilización en SI?."),
            Question("d) Indaga cada cuanto o con que criterios se actualizan los programas de toma de conciencia?."),
            Question("e) Verifica que en las evidencias se puede establecer los asistentes al programa y el tema impartido?."),
            Question("f) Incluye en los temas de toma de conciencia los procedimientos básicos de seguridad de la información (tales como el reporte de incidentes de seguridad de la información) y los controles de línea base (tales como la seguridad de las contraseñas, los controles del software malicioso, y los escritorios limpios)."),
            Question("g) Verifica de acuerdo a NIST que los funcionarios con roles privilegiados entienden sus responsabilidades y roles."),
        ),
        Role.RESPONSABLE_DE_COMPRAS_Y_ADQUISICIONES to listOf(
            Question(
                "1) Solicite la política de seguridad de la información para las relaciones con los proveedores, que indique los requisitos de SI para mitigar los riesgos asociados con el acceso de proveedores a los activos de la organización, esta política debe reflejarse en los acuerdos con los proveedores que deben estar documentados.\n" +
                        "2) Verifique en la muestra de  proveedores  con acceso a los activos de información (no necesariamente son proveedores de tecnología de la información, por ejemplo pueden ser proveedores que tengan por ejemplo un proceso de nomina en outsourcing), se hayan suscrito acuerdos (ANS) formales donde se establezcan y acuerden todos los requisitos de seguridad de la información pertinentes con cada proveedor.\n" +
                        "3) Verifique para los proveedores si se tiene en cuenta los riesgos de SI asociados a la cadena de suministro, por ejemplo para los proveedores en la nube es muy común que se apoyen en otros proveedores para proporcionar las instalaciones y se deben manejar los riesgos asociados a este tercero con el cual la entidad no tiene una relación comercial directa. Solicite que le indiquen como identifican para cada proveedor su cadena de suministro y obtenga evidencia de este hecho."
            ),
            Question(
                "1) Indague y solicite evidencia en una muestra de proveedores seleccionada, como la entidad hace seguimiento, revisa y audita con regularidad de acuerdo a la política la prestación de servicios de los proveedores y el cumplimiento de los compromisos respecto a la seguridad de la información.\n" +
                        "2) Indague y evidencie como se gestionan los cambios en el suministro de servicios por parte de los proveedores, incluido el mantenimiento y la mejora de las políticas, procedimientos y controles de seguridad de la información existentes , teniendo en cuenta la criticidad de la información, sistemas y procesos del negocio involucrados, los incidentes de seguridad de la información y la revaloración de los riesgos."
            ),
        ),
        Role.RESPONSABLE_DE_LA_CONTINUIDAD to listOf(
            Question(
                "Indagar si la Entidad cuenta con un BCP (Bussines Continuity Plan) o DRP (Disaster Recovery Plan).\n" +
                        "Determine si aplica para procesos críticos solamente o se han incluido otros procesos o por lo menos se ha reconocido la necesidad de ampliarlo a otros procesos (para determinar el nivel de madurez)\n" +
                        "Evalúe si se ha incluido en estos planes y procedimientos los requisitos de seguridad de la información.\n" +
                        "Tenga en cuenta que en ausencia de una planificación formal de continuidad de negocio y recuperación de desastres, la dirección de seguridad de la información debería suponer que los requisitos de seguridad de la información siguen siendo los mismos en situaciones adversas, en comparación con las condiciones operacionales normales. Como alternativa, una organización puede llevar a cabo un análisis de impacto en el negocio de los aspectos de seguridad de la información, para determinar los requisitos de seguridad de la información aplicables a situaciones adversas. \n" +
                        "De acuerdo a la NIST también se deben tener planes de respuesta a incidentes y recuperación de incidentes.\n" +
                        "Tenga en cuenta para la calificación:\n" +
                        "1) Si existen planes de continuidad del negocio que contemplen los procesos críticos de la Entidad que garanticen la continuidad de los mismos. Se documentan tan y protegen adecuadamente los planes de continuidad del negocio de la Entidad, este de estar documentado y firmado, por la alta Dirección, están en 40.\n" +
                        "2) Si se reconoce la importancia de ampliar los planes de continuidad de del negocio a otros procesos, pero aun no se pueden incluir ni trabajar con ellos, están en 60."
            ),
            Question(
                "Verifique si la entidad cuenta con\n" +
                        "a) Una estructura organizacional adecuada para prepararse, mitigar y responder a un evento contingente, usando personal con la autoridad, experiencia y competencia necesarias. \n" +
                        "b) Personal formalmente asignado de respuesta a incidentes con la responsabilidad, autoridad y competencia necesarias para manejar un incidente y mantener la seguridad de la información. \n" +
                        "c) Planes aprobados, procedimientos de respuesta y recuperación documentados, en los que se especifique en detalle como la organización gestionará un evento contingente y mantendrá su seguridad de la información en un límite predeterminado, con base en los objetivos de continuidad de seguridad de la información aprobados por la dirección. \n" +
                        "\n" +
                        "Revise si los controles de seguridad de la información que se han implementado continúan operando durante un evento contingente. Si los controles de seguridad no están en capacidad de seguir brindando seguridad a la información, se la Entidad debe establecer, implementar y mantener otros controles para mantener un nivel aceptable de seguridad de la información."
            ),
            Question(
                "Indague y solicite evidencias de la realización de pruebas de la funcionalidad de los procesos, procedimientos y controles de continuidad de la seguridad de la información, para asegurar que son coherentes con los objetivos de continuidad de la seguridad de la información; \n" +
                        " \n" +
                        "Tenga en cuenta que la verificación de los controles de continuidad de la seguridad de la información es diferente de las pruebas y verificación generales de seguridad de la información. Si es posible, es preferible integrar la verificación de los controles de continuidad de negocio de seguridad de la información con las pruebas de recuperación de desastres y de continuidad de negocio de la organización."
            ),
            Question(
                "Verifique si la Entidad cuenta con arquitecturas redundantes, ya sea un centro de cómputo principal y otro alterno o componentes redundantes en el único centro de cómputo.\n" +
                        "Indague como se han definido las necesidades de los procesos para seleccionar que elementos deben ser redundantes.\n" +
                        "Solicite si aplica las pruebas aplicadas para asegurar que un componente redundante funciona de la forma prevista durante una emergencia o falla."
            ),
        ),
        Role.RESPONSABLE_DE_SI to listOf(
            Question(
                "Solicite la política de seguridad de la información de la entidad y evalúe:\n" +
                        "a) Si se definen los objetivos, alcance de la política\n" +
                        "b) Si esta se encuentra alineada con la estrategia y objetivos de la entidad\n" +
                        "c) Si fue debidamente aprobada y socializada al interior de la entidad por la alta dirección\n" +
                        "Revise si la política:\n" +
                        "a)Define que es seguridad de la información\n" +
                        "b) La asignación de las responsabilidades generales y específicas para la gestión de la seguridad de la información, a roles definidos;\n" +
                        "c) Los procesos para manejar las desviaciones y las excepciones.\n" +
                        "Indague sobre los responsables designados formalmente por la dirección para desarrollar, actualizar y revisar las políticas.\n" +
                        "Verifique cada cuanto o bajo que circunstancias se revisan y actualizan, verifique la ultima fecha de emisión de la política frente a la fecha actual y que cambios a sufrido, por lo menos debe haber una revisión anual.\n" +
                        "Para la calificación tenga en cuenta que:\n" +
                        "1) Si se empiezan a definir las políticas de seguridad y privacidad de la información basada en el Modelo de Seguridad y Privacidad de la Información, están en 20.\n" +
                        "2) Si se revisan y se aprueban las políticas de seguridad y privacidad de la información, , están en 40.\n" +
                        "3) Si se divulgan las políticas de seguridad y privacidad de la información,  están en 60."
            ),
            Question(
                "Para revisarlo frente a la NIST verifique si 1) los roles y responsabilidades frente a la ciberseguridad han sido establecidos 2) los roles y responsabilidades de seguridad de la información han sido coordinados y alineados con los roles internos y las terceras partes externas 3) Los a) proveedores, b) clientes, c) socios, d) funcionarios, e) usuarios privilegiados, f) directores y gerentes (mandos senior), g) personal de seguridad física, h) personal de seguridad de la información  entienden sus roles y responsabilidades, i) Están claros los roles y responsabilidades para la detección de incidentes \n" +
                        "Solicite el acto administrativo a través del cual se crea o se modifica las funciones del comité gestión institucional (o e que haga sus veces), en donde se incluyan los temas de seguridad de la información en la entidad, revisado y aprobado por la alta Dirección.\n" +
                        "Revise la estructura del SGSI:\n" +
                        "1) Tiene el SGSI suficiente apoyo de la alta dirección?, esto se ve reflejado en comités donde se discutan temas como la política de SI, los riesgos o incidentes.\n" +
                        "2) Están claramente definidos los roles y responsabilidades y asignados a personal con las competencias requeridas?,\n" +
                        "3) Están identificadas los responsables y responsabilidades para la protección de los activos? (Una práctica común es nombrar un propietario para cada activo, quien entonces se convierte en el responsable de su protección)\n" +
                        "4)Están definidas las responsabilidades para la gestión del riesgo de SI y la aceptación de los riesgos residuales?\n" +
                        "5) Están definidos y documentados los niveles de autorización?\n" +
                        "6) Se cuenta con un presupuesto formalmente asignado a las actividades del SGSI (por ejemplo campañas de sensibilización en seguridad de la información)."
            ),
            Question(
                "Pregunte si la entidad asigna dispositivos móviles a sus funcionarios o permite que los dispositivos de estos ingresen a la entidad.\n" +
                        "Revise si existe una política y controles para su uso, que protejan la información almacenada o procesada en estos dispositivos y el acceso a servicios te TI desde los mismos. \n" +
                        "De acuerdo a las mejores prácticas esta política debe considerar, teniendo en cuenta el uso que se le dé al dispositivo, lo siguiente:\n" +
                        "\n" +
                        "a) el registro de los dispositivos móviles; \n" +
                        "b) los requisitos de la protección física; \n" +
                        "c) las restricciones para la instalación de software; \n" +
                        "d) los requisitos para las versiones de software de dispositivos móviles y para aplicar parches; \n" +
                        "e) la restricción de la conexión a servicios de información; \n" +
                        "f) los controles de acceso;\n" +
                        "g) técnicas criptográficas; \n" +
                        "h) protección contra software malicioso; \n" +
                        "i) des habilitación remota, borrado o cierre; \n" +
                        "j) copias de respaldo; \n" +
                        "k) uso de servicios y aplicaciones web.\n" +
                        "\n" +
                        "Cuando la política de dispositivos móviles permite el uso de dispositivos móviles de propiedad personal, la política y las medidas de seguridad relacionadas también deben considerar: \n" +
                        "a) la separación entre el uso privado y de la Entidad de los dispositivos, incluido el uso del software para apoyar esta separación y proteger los datos del negocio en un dispositivo privado; \n" +
                        "b) brindar acceso a la información de la Entidad solo cuando los usuarios hayan firmado un acuerdo de usuario final, en el que se reconocen sus deberes (protección física, actualización del software, etc.), desistir de la propiedad de los datos de la Entidad, permitir el borrado remoto de datos por parte de la organización en caso de robo o pérdida del dispositivo, o cuando ya no se posee autorización para usar el servicio."
            ),
            Question(
                "Solicite el inventario de activos de información, revisado y aprobado por la alta Dirección y revise:\n" +
                        "1) Ultima vez que se actualizó\n" +
                        "2) Que señale bajo algún criterio la importancia del activo\n" +
                        "3) Que señale el propietario del activo\n" +
                        "Indague quien(es) el(los) encargado(s) de actualizar y revisar el inventario de activos y cada cuanto se realiza esta revisión.\n" +
                        "De acuerdo a NIST  se deben considerar como activos el personal, dispositivos, sistemas e instalaciones físicas que permiten a la entidad cumplir con su misión y objetivos, dada su importancia y riesgos estratégicos.\n" +
                        "Tenga en cuenta para la calificación:\n" +
                        "1) Si Se identifican en forma general los activos de información de la Entidad, están en 40.\n" +
                        "2) Si se cuenta con un inventario de activos de información física y lógica de toda la entidad, documentado y firmado por la alta dirección, están en 60.\n" +
                        "3) Si se revisa y monitorean periódicamente los activos de información de la entidad, están en 80."
            ),
            Question(
                "Verifique si se realizan evaluaciones de seguridad técnicas por o bajo la supervisión de personal autorizado, apoyado en herramientas automáticas o con revisiones manuales realizadas por especialistas. \n" +
                        "Solicite evidencia de las últimas pruebas realizadas, sus resultados y seguimiento para asegurar que las brechas de seguridad fueron solucionadas."
            ),
        ),
        Role.RESPONSABLE_DE_TICS to listOf(
            Question(
                "Definición de teletrabajo: El teletrabajo hace referencia a todas las formas de trabajo por fuera de la oficina, incluidos los entornos de trabajo no tradicionales, a los que se denomina \"trabajo a distancia\", \"lugar de trabajo flexible\", \"trabajo remoto\" y ambientes de \"trabajo virtual\".\n" +
                        "\n" +
                        "Indague con la entidad si el personal o terceros pueden realizar actividades de teletrabajo, si la respuesta es positiva solicite la política que indica las condiciones y restricciones para el uso del teletrabajo. Las mejores prácticas consideran los siguientes controles:\n" +
                        "a) la seguridad física existente en el sitio del teletrabajo \n" +
                        "b) los requisitos de seguridad de las comunicaciones, teniendo en cuenta la necesidad de acceso remoto a los sistemas internos de la organización, la sensibilidad de la información a la que se tendrá acceso y que pasará a través del enlace de comunicación y la sensibilidad del sistema interno; \n" +
                        "c) el suministro de acceso al escritorio virtual, que impide el procesamiento y almacenamiento de información en equipo de propiedad privada; \n" +
                        "d) la amenaza de acceso no autorizado a información o a recursos, por parte de otras personas que usan el mismo equipo, por ejemplo, familia y amigos; \n" +
                        "e) el uso de redes domésticas y requisitos o restricciones sobre la configuración de servicios de red inalámbrica; \n" +
                        "e) acuerdos de licenciamiento de software de tal forma que las organizaciones puedan llegar a ser responsables por el licenciamiento de software de los clientes en estaciones de trabajo de propiedad de los empleados o de usuarios externos; \n" +
                        "f) requisitos de firewall y de protección contra software malicioso. \n" +
                        "Las directrices y acuerdos que se consideren deberían incluir: \n" +
                        "g) el suministro de equipo adecuado y de muebles de almacenamiento para las actividades de teletrabajo, cuando no se permite el uso del equipo de propiedad privada que no está bajo el control de la organización; \n" +
                        "h) una definición del trabajo permitido, las horas de trabajo, la clasificación de la información que se puede mantener, y los sistemas y servicios internos a los que el tele trabajador está autorizado a acceder; \n" +
                        "i) el suministro de equipos de comunicación adecuados, incluidos los métodos para asegurar el acceso remoto; \n" +
                        "j) la revocación de la autoridad y de los derechos de acceso, y la devolución de los equipos cuando las actividades del teletrabajo finalicen."
            ),
            Question(
                "Solicite las directrices, guías, lineamientos y procedimientos para la gestión de medios removibles, que consideren:\n" +
                        "a) Si ya no se requiere, el contenido de cualquier medio reusable que se vaya a retirar de la organización se debe remover de forma que no sea recuperable; \n" +
                        "b) cuando resulte necesario y práctico, se debe solicitar autorización para retirar los medios de la organización, y se debe llevar un registro de dichos retiros con el fin de mantener un rastro de auditoría; \n" +
                        "d) si la confidencialidad o integridad de los datos se consideran importantes, se deben usar técnicas criptográficas para proteger los datos que se encuentran en los medios removibles; \n" +
                        "f) se deben guardar varias copias de los datos valiosos en medios separados, para reducir aún más el riesgo de daño o pérdida casuales de los datos; \n" +
                        "h) sólo se deben habilitar unidades de medios removibles si hay una razón de valida asociada a los procesos la Entidad para hacerlo; \n" +
                        "i) En donde hay necesidad de usar medios removibles, se debería hacer seguimiento a la transferencia de información a estos medios (Por ejemplo DLP)."
            ),
            Question(
                "Solicite los procedimientos existentes para garantizar que los medios a desechar o donar, no contienen información confidencial que pueda ser consultada y copiada por personas no autorizadas.\n" +
                        "\n" +
                        "Verifique si se ha realizado esta actividad y si existen registros de la misma."
            ),
            Question(
                "Solicite las directrices definidas para la protección de medios que contienen información durante el transporte. Verifique de acuerdo a las mejores prácticas que se contemple:\n" +
                        "\n" +
                        "a) El uso de un transporte o servicios de mensajería confiables.\n" +
                        "b) Procedimientos para verificar la identificación de los servicios de mensajería.\n" +
                        "c) Indague y evidencie como es el embalaje el cual debe proteger el contenido contra cualquier daño físico que pudiera presentarse durante el tránsito, y de acuerdo con las especificaciones de los fabricantes, por ejemplo, protección contra cualquier factor ambiental que pueda reducir la eficacia de la restauración del medio, tal como exposición al calor, humedad o campos electromagnéticos; \n" +
                        "d) Solicite los registros que dejen evidencia del transporte donde se identifique el contenido de los medios, la protección aplicada, al igual que los tiempos de transferencia a los responsables durante el transporte, y el recibo en su destino."
            ),
            Question(
                "1) Solicite los procedimientos para el cumplimiento de los requisitos y contractuales relacionados con los derechos de propiedad intelectual y el uso de productos de software patentados. \n" +
                        "2) Verifique si la Entidad cuenta con una política publicada sobre el cumplimiento de derechos de propiedad intelectual que defina el uso legal del software y de productos informáticos. Esta política debe estar orientada no solo al software, si no también a documentos gráficos, libros, etc.\n" +
                        "3) Indague como se controla que no se instale software ilegal.\n" +
                        "4) Indague si se tiene un inventario de software instalado y se compara con el número de licencias adquiridas para asegurar que no se incumplen los derechos de propiedad intelectual. Tenga en cuenta los controles que deben existir para asegurar que no se exceda ningún número máximo de usuarios permitido dentro de la licencia."
            ),
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
