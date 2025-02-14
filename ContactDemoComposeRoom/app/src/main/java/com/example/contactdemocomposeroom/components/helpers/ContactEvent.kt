package com.example.contactdemocomposeroom.components.helpers

import com.example.contactdemocomposeroom.components.roomdatabase.Contact


sealed interface ContactEvent {
    object SaveContact: ContactEvent

    data class DeleteContact(val contact: Contact): ContactEvent

    data class SetFirstName(val firstName: String): ContactEvent
    data class SetLastName(val lastName: String): ContactEvent
    data class SetPhoneNumber(val phoneNumber: String): ContactEvent

    object ShowDialog: ContactEvent
    object HideDialog: ContactEvent

    data class SortContacts(val sortType: SortType): ContactEvent
}