package com.example.teacherassistant.view_model

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.teacherassistant.data.AppDatabase
import com.example.teacherassistant.model.Course
import com.example.teacherassistant.model.Participant
import com.example.teacherassistant.model.Student
import com.example.teacherassistant.repository.CourseRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CourseViewModel(application: Application): AndroidViewModel(application) {

    val readAllCourses: LiveData<List<Course>>
    val readAllParticipant:  LiveData<List<Participant>>
    private val repository: CourseRepository

    init {
        val courseDao = AppDatabase.getDatabase(application).courseDao()
        val participantDao = AppDatabase.getDatabase(application).participantDao()
        repository = CourseRepository(courseDao,participantDao)
        readAllCourses = repository.readAllCourses
        readAllParticipant = repository.readAllParticipant
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

     fun addStudentsToCourse(studentsList: MutableList<Student>,course : Course){

        studentsList.forEach {
            viewModelScope.launch(Dispatchers.IO) {
                repository.addParticipant(Participant(0,it.id,course.id))
            }
        }
    }

    fun getCourseByName(name:String) : Course{
        var course = repository.getCourseByName(name)
        if(course == null ) course = Course(100,"Error")
        return course
    }

    fun readParticipantFromCourse(course:Course): LiveData<List<Student>> {
        return repository.readParticipantFromCourse(course)
    }

//    fun deleteAllParticipantFromCourse(courseId:Int){
//        viewModelScope.launch(Dispatchers.IO) {
//            repository.deleteParticipant(courseId)
//        }
//    }

}