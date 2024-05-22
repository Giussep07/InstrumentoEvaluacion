package com.giussepr.instrumentoevaluacion.uicomponents.selector

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.giussepr.instrumentoevaluacion.uicomponents.TextFieldState

@ExperimentalMaterial3Api
@Composable
fun AppSelector(
    modifier: Modifier = Modifier,
    label: String,
    selectorItem: SelectorItem?,
    items: List<SelectorItem>,
    onItemSelected: (SelectorItem) -> Unit,
    isError: Boolean,
    textFieldState: TextFieldState,
    isExpanded: Boolean,
    onExpandedChange: (Boolean) -> Unit,
    onDismissRequest: () -> Unit,
) {
    val supportingTextComposable: @Composable (() -> Unit)? =
        if (textFieldState.supportingText.isNullOrEmpty().not()) {
            {
                Text(
                    text = textFieldState.supportingText.orEmpty(),
                )
            }
        } else {
            null
        }
    ExposedDropdownMenuBox(
        modifier = modifier,
        expanded = isExpanded,
        onExpandedChange = onExpandedChange,
    ) {
        OutlinedTextField(
            // The `menuAnchor` modifier must be passed to the text field for correctness.
            modifier = modifier
                .menuAnchor(),
            readOnly = true,
            value = selectorItem?.text ?: "",
            onValueChange = {},
            label = { Text(label) },
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded) },
            colors = ExposedDropdownMenuDefaults.textFieldColors()
                .copy(
                    unfocusedContainerColor = MaterialTheme.colorScheme.surface,
                    focusedContainerColor = MaterialTheme.colorScheme.surface,
                    errorContainerColor = MaterialTheme.colorScheme.surface,
                ),
            supportingText = supportingTextComposable,
            isError = isError,
            maxLines = 1,
        )
        ExposedDropdownMenu(
            modifier = Modifier.fillMaxWidth(),
            expanded = isExpanded,
            onDismissRequest = onDismissRequest,
        ) {
            items.forEach { selectionOption ->
                DropdownMenuItem(
                    modifier = Modifier.fillMaxWidth(),
                    text = { Text(selectionOption.text) },
                    onClick = {
                        onItemSelected(selectionOption)
                        onDismissRequest()
                    },
                    contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding,
                )
            }
        }
    }
}
