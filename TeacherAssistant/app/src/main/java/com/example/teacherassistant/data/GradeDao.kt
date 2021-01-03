package com.example.teacherassistant.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.teacherassistant.model.Grade
import com.example.teacherassistant.model.GradeFull
import java.util.*

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

    @Query("SELECT s.id as s_id, s.firstName as s_firstName, s.lastName as s_lastName, g.id, g.course_id, g.student_id, g.date, g.description, g.grade, c.courseName as c_courseName, c.id as c_id  FROM grade_table as g join student_table as s on g.student_id = s.id join course_table as c on g.course_id = c.id WHERE g.date > date('now','-1 day')")
    fun readFullTodayGrades():LiveData<List<GradeFull>>

}