package com.example.teacherassistant.repository

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.teacherassistant.data.CourseDao
import com.example.teacherassistant.data.ParticipantDao
import com.example.teacherassistant.model.Course
import com.example.teacherassistant.model.Participant
import com.example.teacherassistant.model.Student

class CourseRepository(private val courseDao: CourseDao,
                       private val participantDao: ParticipantDao) {

    val readAllCourses: LiveData<List<Course>> = courseDao.readAll()
    val readAllParticipant:  LiveData<List<Participant>> = participantDao.readAll()

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

    fun readParticipantFromCourse(course: Course) : LiveData<List<Student>>{
        return participantDao.readStudentsFromCourse(course.id)
    }

    fun getCourseByName(name:String): Course? {
        val list = courseDao.readAll()
        return list.value?.get(0)
    }



}