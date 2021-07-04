package com.peculiaruc.wineshop.dataSource

import android.content.Context
import com.peculiaruc.wineshop.api.RetrofitService
import com.peculiaruc.wineshop.dataSource.local.db.UserDatabase
import com.peculiaruc.wineshop.dataSource.local.db.UserEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class Repository( private val retrofitService: RetrofitService, context: Context) {
    suspend fun getDrinks(drink:String) = retrofitService.getDrinks(drink)

    suspend fun getDrinkDetails(id:String) = retrofitService.getDrinkDetails(id)

    private val db = UserDatabase.invoke(context)

    // fun getAllContact(): LiveData<List<ContactEntity>> = database.contactDao().selectAllContacts()

    // fun insertContacts(contactEntity: ContactEntity) = database.contactDao().insertContacts(contactEntity)
    fun insertUser(userEntity: UserEntity){
        GlobalScope.launch{
            withContext(Dispatchers.IO){
                db.userDao().insertUser(userEntity) }  }  }

    fun isValidUser(email: String, password: String): Boolean {
        val validUser: UserEntity? = db.userDao().getUserData(email)

        return  if (validUser != null) {
            validUser.password == password
        }else {
            false
        }
    }

    fun isExisting(email: String): Boolean {
        val existingUser: UserEntity? = db.userDao().getUserData(email)

        return existingUser != null
    }
}