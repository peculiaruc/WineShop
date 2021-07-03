package com.peculiaruc.wineshop.dataSource.local.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [WineEntity::class], version = 1)
abstract class WineDatabase: RoomDatabase() {

        abstract fun contactDao(): WineDao

        companion object {
            @Volatile
            private var instance: WineDatabase? = null
            private val LOCK = Any()

            operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
                instance ?: buildDatabase(context)
            }

            private fun buildDatabase(context: Context) = Room.databaseBuilder(context, WineDatabase::class.java, "contact.db").allowMainThreadQueries().build()


        }
    }
