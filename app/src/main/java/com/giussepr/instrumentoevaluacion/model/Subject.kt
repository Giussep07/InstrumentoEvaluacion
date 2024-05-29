package com.giussepr.instrumentoevaluacion.model

import com.giussepr.instrumentoevaluacion.uicomponents.selector.SelectorItem

data class Subject(
    val name: String
): SelectorItem {
    override val text: String
        get() = name
}
