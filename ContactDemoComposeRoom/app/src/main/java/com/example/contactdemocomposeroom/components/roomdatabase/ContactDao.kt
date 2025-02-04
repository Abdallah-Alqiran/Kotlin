package com.example.contactdemocomposeroom.components.roomdatabase

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ContactDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertContact(contact: Contact)

    @Delete
    suspend fun deleteContact(contact: Contact)

    @Query("SELECT * FROM contact_table ORDER BY firstName ASC")
    fun getAllContactsOrderedByFirstName(): Flow<List<Contact>>

    @Query("SELECT * FROM contact_table ORDER BY lastName ASC")
    fun getAllContactsOrderedByLastName(): Flow<List<Contact>>

    @Query("SELECT * FROM contact_table ORDER BY phoneNumber ASC")
    fun getAllContactsOrderedByPhoneNumber(): Flow<List<Contact>>
}

