package com.example.teacherassistant.repository

import androidx.lifecycle.LiveData
import com.example.teacherassistant.data.CourseDao
import com.example.teacherassistant.data.ParticipantDao
import com.example.teacherassistant.model.Course
import com.example.teacherassistant.model.Participant

class CourseRepository(private val courseDao: CourseDao,
                       private val participantDao: ParticipantDao) {

    val readAllCourses: LiveData<List<Course>> = courseDao.readAll()

    suspend fun addCourse(course: Course){
        courseDao.add(course)
    }

    suspend fun updateCourse(course: Course){
        courseDao.update(course)
    }

    suspend fun deleteCourse(course: Course){
        courseDao.delete(course)
    }

    suspend fun addParticipant(participant: Participant){
        participantDao.add(participant)
    }

    suspend fun deleteParticipant(participant: Participant){
        participantDao.delete(participant)
    }

    suspend fun readParticipantFromCourse(course: Course) : LiveData<List<Participant>>{
        return participantDao.readParticipantFromCourse(course.id)
    }
}