package com.giussepr.instrumentoevaluacion.model

import com.giussepr.instrumentoevaluacion.uicomponents.selector.SelectorItem

enum class Role(val value: String) : SelectorItem {
    CONTROL_INTERNO("Control interno"),
    LIDER_DE_PROCESO_1("Líder de Proceso 1"),
    RESPONSABLE_DE_COMPRAS_Y_ADQUISICIONES("Responsable de compras y adquisiciones"),
    RESPONSABLE_DE_LA_CONTINUIDAD("Responsable de la continuidad"),
    RESPONSABLE_DE_SI("Responsable de SI"),
    RESPONSABLE_DE_TICS("Responsable de TICs")
    ;

    override val text: String
        get() = value
}
