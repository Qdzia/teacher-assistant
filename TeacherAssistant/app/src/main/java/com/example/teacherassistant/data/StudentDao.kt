package com.example.teacherassistant.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.teacherassistant.model.Student

@Dao
interface StudentDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addStudent(user: Student)

    @Update
    suspend fun updateStudent(user: Student)

    @Delete
    suspend fun deleteStudent(user: Student)

    @Query("DELETE FROM student_table")
    suspend fun deleteAllStudents()

    @Query("SELECT * FROM student_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<Student>>

}