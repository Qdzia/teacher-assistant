package com.example.teacherassistant.repository

import androidx.lifecycle.LiveData
import com.example.teacherassistant.data.CourseDao
import com.example.teacherassistant.model.Course

class CourseRepository(private val courseDao: CourseDao) {

    val readAllData: LiveData<List<Course>> = courseDao.readAll()

    suspend fun addCourse(course: Course){
        courseDao.add(course)
    }

    suspend fun updateCourse(course: Course){
        courseDao.update(course)
    }

    suspend fun deleteCourse(course: Course){
        courseDao.delete(course)
    }
}