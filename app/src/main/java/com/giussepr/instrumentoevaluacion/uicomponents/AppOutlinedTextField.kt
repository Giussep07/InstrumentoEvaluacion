package com.giussepr.instrumentoevaluacion.uicomponents

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.giussepr.instrumentoevaluacion.ui.theme.InstrumentoEvaluacionTheme

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
    textFieldState: TextFieldState,
    maxLength: Int? = null
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
        onValueChange = {
            if (maxLength != null && it.length <= maxLength) {
                onValueChange(it)
            } else if (maxLength == null) {
                onValueChange(it)
            }
        },
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

@Composable
fun AppLabeledOutlinedTextField(
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

    Column {
        Text(
            text = label,
            style = MaterialTheme.typography.labelLarge,
        )
        Spacer(modifier = Modifier.size(4.dp))
        OutlinedTextField(
            modifier = modifier,
            value = value,
            onValueChange = onValueChange,
            placeholder = {
                Text(placeholder)
            },
            maxLines = maxLines,
            keyboardOptions = keyboardOptions,
            keyboardActions = keyboardActions,
            isError = isPriceError,
            supportingText = supportingTextComposable
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AppLabeledOutlinedTextFieldPreview() {
    InstrumentoEvaluacionTheme {
        AppLabeledOutlinedTextField(
            value = "Value",
            onValueChange = {},
            placeholder = "Placeholder",
            label = "Label",
            keyboardOptions = KeyboardOptions.Default,
            textFieldState = TextFieldState.Default
        )
    }
}
