package com.trichain.expensemanager.room.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import com.trichain.expensemanager.room.tables.CategoryTable

@Dao
interface CategoryDao {
    @Insert(onConflict = REPLACE)
    fun insert(data: CategoryTable)

    @Delete
    fun delete(data: CategoryTable)

    @Update
    fun update(data: CategoryTable): Int

    @Query("SELECT * from CategoryTable ORDER BY id ASC")
    fun getAll(): List<CategoryTable>


    @Query("SELECT * from CategoryTable ORDER BY id ASC")
    fun getAllL(): LiveData<List<CategoryTable>>

    @Query("SELECT * FROM CategoryTable WHERE id = :id LIMIT 1")
    fun getNote(id: Int): CategoryTable

    @Query("DELETE FROM CategoryTable")
    fun deleteAll(): Int
}