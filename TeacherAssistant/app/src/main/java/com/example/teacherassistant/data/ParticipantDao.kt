package com.example.teacherassistant.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.teacherassistant.model.Course
import com.example.teacherassistant.model.Participant

@Dao
interface ParticipantDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun add(participant: Participant)

    @Update
    suspend fun update(participant: Participant)

    @Delete
    suspend fun delete(participant: Participant)

    @Query("SELECT * FROM participant_table WHERE course_id = :courseId")
    fun readParticipantFromCourse(courseId : Int): LiveData<List<Participant>>


}