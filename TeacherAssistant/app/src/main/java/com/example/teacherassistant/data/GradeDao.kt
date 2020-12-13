package com.example.teacherassistant.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.teacherassistant.model.Grade

@Dao
interface GradeDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun add(grade: Grade)

    @Update
    suspend fun update(grade: Grade)

    @Delete
    suspend fun delete(grade: Grade)

    @Query("SELECT * FROM grade_table ORDER BY id ASC")
    fun readAll(): LiveData<List<Grade>>

    @Query("SELECT * FROM grade_table WHERE student_id = :studentId AND course_id = :courseId")
    fun readFromStudentCourse(studentId: Int,courseId:Int): LiveData<List<Grade>>

}