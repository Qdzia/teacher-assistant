package com.example.teacherassistant.repository

import androidx.lifecycle.LiveData
import com.example.teacherassistant.data.CourseDao
import com.example.teacherassistant.data.ParticipantDao
import com.example.teacherassistant.model.Course
import com.example.teacherassistant.model.Participant
import com.example.teacherassistant.model.Student


class ParticipantRepsitory(private val participantDao: ParticipantDao) {

    val readAll: LiveData<List<Participant>> = participantDao.readAll()

    suspend fun addParticipant(participant: Participant){
        participantDao.add(participant)
    }

    suspend fun deleteParticipant(participant: Participant){
        participantDao.delete(participant)
    }

    fun readFromCourse(courseId: Int) : LiveData<List<Student>> {
        return participantDao.readFromCourse(courseId)
    }

    suspend fun deleteAllFromCourse(courseId: Int){
        participantDao.deleteAllFromCourse(courseId)
    }

}