package com.example.teacherassistant.repository

import androidx.lifecycle.LiveData
import com.example.teacherassistant.data.StudentDao
import com.example.teacherassistant.model.Student

class StudentRepository(private val studentDao: StudentDao) {

    val readAllData: LiveData<List<Student>> = studentDao.readAllData()

    suspend fun addStudent(student: Student){
        studentDao.addStudent(student)
    }

    suspend fun updateStudent(student: Student){
        studentDao.updateStudent(student)
    }

    suspend fun deleteStudent(student: Student){
        studentDao.deleteStudent(student)
    }

//    suspend fun deleteAllStudents(){
//        userDao.deleteAllStudent()
//    }

}