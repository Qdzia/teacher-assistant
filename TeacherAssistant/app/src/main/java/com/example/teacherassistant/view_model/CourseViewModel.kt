package com.example.teacherassistant.view_model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.teacherassistant.data.AppDatabase
import com.example.teacherassistant.model.Course
import com.example.teacherassistant.model.Student
import com.example.teacherassistant.repository.CourseRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CourseViewModel(application: Application): AndroidViewModel(application) {

    val readAllCourses: LiveData<List<Course>>
    private val repository: CourseRepository

    init {
        val courseDao = AppDatabase.getDatabase(application).courseDao()
        val participantDao = AppDatabase.getDatabase(application).participantDao()
        repository = CourseRepository(courseDao,participantDao)
        readAllCourses = repository.readAllCourses
    }

    fun addCourse(course: Course){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addCourse(course)
        }
    }

    fun updateCourse(course: Course){
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateCourse(course)
        }
    }

    fun deleteCourse(course: Course){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteCourse(course)
        }
    }

}