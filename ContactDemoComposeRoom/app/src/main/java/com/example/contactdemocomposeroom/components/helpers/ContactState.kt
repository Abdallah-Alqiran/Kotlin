package com.example.contactdemocomposeroom.components.helpers

import com.example.contactdemocomposeroom.components.roomdatabase.Contact

data class ContactState(
    val firstName: String = "",
    val lastName: String = "",
    val phoneNumber: String = "",
    val contacts: List<Contact> = emptyList(),
    val isAddingContact: Boolean = false,
    val sortType: SortType = SortType.FIRST_NAME
)