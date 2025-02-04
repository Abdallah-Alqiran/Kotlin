package com.example.contactdemocomposeroom.ui

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.contactdemocomposeroom.components.helpers.ContactEvent
import com.example.contactdemocomposeroom.components.helpers.ContactState

@Composable
fun DialogScreen(
    state: ContactState,
    onEvent: (ContactEvent) -> Unit,
) {
    AlertDialog(
        onDismissRequest = { onEvent(ContactEvent.HideDialog) },
        confirmButton = {
            Button(
                onClick = {
                    Log.d("THE_CHECK", "${state.firstName} ${state.lastName} ${state.phoneNumber}")
                    onEvent(ContactEvent.SaveContact)
                }) {
                Text(text = "Save")
            }
        },
        title = {
            Text(text = "Add Contact")
        },
        text = {
            Column {
                TextField(
                    value = state.firstName,
                    onValueChange = { onEvent(ContactEvent.SetFirstName(it)) }
                )
                TextField(
                    value = state.lastName,
                    onValueChange = { onEvent(ContactEvent.SetLastName(it)) }
                )
                TextField(
                    value = state.phoneNumber,
                    onValueChange = { onEvent(ContactEvent.SetPhoneNumber(it)) }
                )
            }
        }
    )
}