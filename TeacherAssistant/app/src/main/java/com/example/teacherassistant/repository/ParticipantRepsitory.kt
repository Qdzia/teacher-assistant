package com.example.teacherassistant.repository

import androidx.lifecycle.LiveData
import com.example.teacherassistant.data.CourseDao
import com.example.teacherassistant.data.ParticipantDao
import com.example.teacherassistant.model.Course
import com.example.teacherassistant.model.Participant
import com.example.teacherassistant.model.Student
import com.example.teacherassistant.model.StudentLastGrade


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
    fun readFromCourseWithGrade(courseId: Int) : LiveData<List<StudentLastGrade>> {
        return participantDao.readFromCourseWithGrade(courseId)
    }

    suspend fun deleteAllFromCourse(courseId: Int){
        participantDao.deleteAllFromCourse(courseId)
    }

}