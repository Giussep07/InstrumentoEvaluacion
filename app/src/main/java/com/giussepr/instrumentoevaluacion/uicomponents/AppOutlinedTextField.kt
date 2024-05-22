package com.giussepr.instrumentoevaluacion.uicomponents

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun AppOutlinedTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    label: String,
    maxLines: Int = 1,
    keyboardOptions: KeyboardOptions,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    textFieldState: TextFieldState
) {
    val isPriceError = textFieldState is TextFieldState.Error
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

    OutlinedTextField(
        modifier = modifier,
        value = value,
        onValueChange = onValueChange,
        placeholder = {
            Text(placeholder)
        },
        label = {
            Text(label)
        },
        maxLines = maxLines,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        isError = isPriceError,
        supportingText = supportingTextComposable
    )
}
