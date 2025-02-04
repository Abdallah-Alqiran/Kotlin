package com.example.contactdemocomposeroom.ui

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.contactdemocomposeroom.components.helpers.ContactEvent
import com.example.contactdemocomposeroom.components.helpers.ContactState
import com.example.contactdemocomposeroom.components.helpers.SortType

@Composable
fun ContactScreen(state: ContactState, onEvent: (ContactEvent) -> Unit) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { onEvent(ContactEvent.ShowDialog) }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "adding new contact")
            }
        }
    ) {
        Modifier.padding(it)

        if(state.isAddingContact) {
            DialogScreen(state = state, onEvent = onEvent)
        }

        Column(
            modifier = Modifier.padding(10.dp)
        ) {
            LazyRow{
                items(SortType.entries.toTypedArray()) { sortType ->
                    RadioButton(
                        selected = state.sortType == sortType
                        ,onClick = {
                            onEvent(ContactEvent.SortContacts(sortType))
                        })
                    Text(text = sortType.toString())
                }
            }

            LazyColumn(
                modifier = Modifier.padding(4.dp)
            ) {
                items(state.contacts) { contact ->
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                    ) {
                        Column(
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(
                                text = "${contact.firstName} ${contact.lastName}"
                            )
                            Text(
                                text = contact.phoneNumber
                            )
                        }
                        IconButton(onClick = {onEvent(ContactEvent.DeleteContact(contact)) }) {
                            Icon(imageVector = Icons.Default.Delete, contentDescription = null)
                        }

                    }
                }
            }
        }



    }
}