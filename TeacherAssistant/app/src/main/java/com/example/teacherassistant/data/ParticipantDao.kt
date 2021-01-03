package com.example.teacherassistant.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.teacherassistant.model.*

@Dao
interface ParticipantDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun add(participant: Participant)

    @Delete
    suspend fun delete(participant: Participant)

    @Query("SELECT s.id, s.firstName,s.lastName  FROM student_table s JOIN participant_table p on s.id = p.student_id  WHERE course_id = :courseId")
    fun readFromCourse(courseId : Int): LiveData<List<Student>>

    @Query("SELECT * FROM participant_table ORDER BY id ASC")
    fun readAll():  LiveData<List<Participant>>

    @Query("DELETE FROM participant_table WHERE course_id = :courseId")
    fun deleteAllFromCourse(courseId:Int)

    @Query("SELECT s.id as s_id, s.firstName as s_firstName,s.lastName as s_lastName, g.id,g.student_id,g.course_id,AVG(g.grade) as grade,g.description, MAX(g.date) as date FROM grade_table g JOIN student_table s on g.student_id = s.id WHERE g.course_id = :courseId GROUP BY s.id"  )
    fun readFromCourseWithGrade(courseId : Int): LiveData<List<StudentLastGrade>>
}