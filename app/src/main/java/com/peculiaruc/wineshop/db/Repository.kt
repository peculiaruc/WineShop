package com.peculiaruc.wineshop.db

import android.content.Context
import com.peculiaruc.wineshop.api.RetrofitService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class Repository( private val retrofitService: RetrofitService, context: Context) {
    suspend fun getDrinks(drink:String) = retrofitService.getDrinks(drink)

    suspend fun getDrinkDetails(id:String) = retrofitService.getDrinkDetails(id)

    private val db = WineDatabase.invoke(context)

    // fun getAllContact(): LiveData<List<ContactEntity>> = database.contactDao().selectAllContacts()

    // fun insertContacts(contactEntity: ContactEntity) = database.contactDao().insertContacts(contactEntity)
    fun insertContacts(contactEntity: WineEntity){
        GlobalScope.launch{
            withContext(Dispatchers.IO){
                db.contactDao().insertContacts(contactEntity) }  }  }

    fun isValidContact(email: String, password: String): Boolean {
        val validContact: WineEntity? = db.contactDao().getContactData(email)

        return  if (validContact != null) {
            validContact.password == password
        }else {
            false
        }
    }

    fun isExisting(email: String): Boolean {
        val existingContact: WineEntity? = db.contactDao().getContactData(email)

        return existingContact != null
    }
}