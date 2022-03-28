package com.trichain.expensemanager.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.trichain.expensemanager.room.daos.CategoryDao
import com.trichain.expensemanager.room.tables.CategoryTable

@Database(entities = [CategoryTable::class] /* List tables Ex:NoteModel */, version = 1)
abstract class MyDatabase:RoomDatabase() {
    abstract fun categoryDao(): CategoryDao // CategoryDao

    companion object {
        private var INSTANCE: MyDatabase? = null

        fun getInstance(context: Context): MyDatabase? {
            if (INSTANCE == null) {
                synchronized(MyDatabase::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        MyDatabase::class.java, "ExpenseDataBase" // Database Name
                    ).allowMainThreadQueries().build()
                }
            }
            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}