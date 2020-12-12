package com.example.teacherassistant.view_model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.teacherassistant.data.AppDatabase
import com.example.teacherassistant.model.Grade
import com.example.teacherassistant.repository.StudentRepository
import com.example.teacherassistant.model.Student
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class StudentViewModel(application: Application): AndroidViewModel(application) {

    val readAllData: LiveData<List<Student>>
    val readAllGrades: LiveData<List<Grade>>

    private val repository: StudentRepository

    init {
        val studentDao = AppDatabase.getDatabase(
            application
        ).studentDao()
        val gradeDao = AppDatabase.getDatabase(
            application
        ).gradeDao()

        repository = StudentRepository(studentDao,gradeDao)
        readAllData = repository.readAllData
        readAllGrades = repository.readAllGrades

    }

    fun addStudent(user: Student){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addStudent(user)
        }
    }

    fun updateStudent(user: Student){
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateStudent(user)
        }
    }

    fun deleteStudent(user: Student){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteStudent(user)
        }
    }

    fun addGrade(grade: Grade){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addGrade(grade)
        }
    }
//    fun deleteAllUsers(){
//        viewModelScope.launch(Dispatchers.IO) {
//            repository.deleteAllStudents()
//        }
}

