package com.example.teacherassistant.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.teacherassistant.model.Course
import com.example.teacherassistant.model.Participant
import com.example.teacherassistant.model.Student

@Dao
interface ParticipantDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun add(participant: Participant)

    @Delete
    suspend fun delete(participant: Participant)

    @Query("SELECT s.id, s.firstName,s.lastName  FROM student_table s JOIN participant_table p on s.id = p.student_id  WHERE course_id = :courseId")
    //@Query("SELECT * FROM participant_table")
    fun readFromCourse(courseId : Int): LiveData<List<Student>>

    @Query("SELECT * FROM participant_table ORDER BY id ASC")
    fun readAll():  LiveData<List<Participant>>

    @Query("DELETE FROM participant_table WHERE course_id = :courseId")
    fun deleteAllFromCourse(courseId:Int)

}