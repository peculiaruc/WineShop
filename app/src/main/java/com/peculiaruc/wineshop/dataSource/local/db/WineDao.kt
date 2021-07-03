package com.peculiaruc.wineshop.dataSource.local.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface WineDao {
    @Query("SELECT * FROM contact")
    fun selectAllContacts(): LiveData<List<WineEntity>>

    @Query("SELECT * FROM contact WHERE contact.email LIKE:email")
    fun getContactData(email: String): WineEntity

    @Insert
    fun insertContacts(contactEntity: WineEntity)

    @Delete
    fun deleteContacts(contactEntity: WineEntity)

    @Update
    fun updateContacts(contactEntity: WineEntity)

}