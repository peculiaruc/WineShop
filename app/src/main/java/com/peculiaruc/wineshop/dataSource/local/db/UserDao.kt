package com.peculiaruc.wineshop.dataSource.local.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    fun selectAllUser(): LiveData<List<UserEntity>>

    @Query("SELECT * FROM user WHERE user.email LIKE:email")
    fun getUserData(email: String): UserEntity

    @Insert
    fun insertUser(userEntity: UserEntity)

    @Delete
    fun deleteUser(userEntity: UserEntity)

    @Update
    fun updateUser(userEntity: UserEntity)

}