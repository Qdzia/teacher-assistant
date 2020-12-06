package com.example.teacherassistant.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.teacherassistant.model.Student

@Dao
interface StudentDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun add(user: Student)

    @Update
    suspend fun update(user: Student)

    @Delete
    suspend fun delete(user: Student)

    @Query("DELETE FROM student_table")
    suspend fun deleteAll()

    @Query("SELECT * FROM student_table ORDER BY id ASC")
    fun readAll(): LiveData<List<Student>>

}