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
import com.example.teacherassistant.model.StudentLastGrade
import com.example.teacherassistant.repository.ParticipantRepsitory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class ParticipantViewModel(application: Application): AndroidViewModel(application) {

    val readAll: LiveData<List<Participant>>
    private val repository: ParticipantRepsitory

    init {
        val participantDao = AppDatabase.getDatabase(application).participantDao()
        repository = ParticipantRepsitory(participantDao)
        readAll = repository.readAll
    }

    fun addParticipants(studentsList: MutableList<Student>, course : Course){

        studentsList.forEach {
            viewModelScope.launch(Dispatchers.IO) {
                repository.addParticipant(Participant(0,it.id,course.id))
            }
        }
    }

    fun readParticipantFromCourse(course: Course): LiveData<List<Student>> {
        return repository.readFromCourse(course.id)
    }
    fun readFromCourseWithGrade(course: Course): LiveData<List<StudentLastGrade>> {
        return repository.readFromCourseWithGrade(course.id)
    }

    fun deleteAllParticipantFromCourse(courseId:Int){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllFromCourse(courseId)
        }
    }

}