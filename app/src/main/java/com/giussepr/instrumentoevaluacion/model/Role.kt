package com.giussepr.instrumentoevaluacion.model

import com.giussepr.instrumentoevaluacion.uicomponents.selector.SelectorItem

data class Role(
    val name: String = "",
    val areas: List<Area> = emptyList(),
) : SelectorItem {
    override val text: String
        get() = name
}

data class Area(
    val name: String = "",
) : SelectorItem {
    override val text: String
        get() = name
}
