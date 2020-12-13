package com.example.teacherassistant.view_model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.teacherassistant.data.AppDatabase
import com.example.teacherassistant.model.Course
import com.example.teacherassistant.model.Grade
import com.example.teacherassistant.model.Participant
import com.example.teacherassistant.model.Student
import com.example.teacherassistant.repository.GradeRepository
import com.example.teacherassistant.repository.ParticipantRepsitory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GradeViewModel(application: Application): AndroidViewModel(application) {

    val readAll: LiveData<List<Grade>>
    private val repository: GradeRepository

    init {
        val gradeDao = AppDatabase.getDatabase(application).gradeDao()
        repository = GradeRepository(gradeDao)
        readAll = repository.readAll
    }

    fun addGrade(grade: Grade){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addGrade(grade)
        }
    }

    fun readStudentCourseGrades(student : Student,course: Course): LiveData<List<Grade>> {
        return repository.readFromStudentCourse(student.id,course.id)
    }


}

