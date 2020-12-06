package com.example.teacherassistant.repository

import androidx.lifecycle.LiveData
import com.example.teacherassistant.data.StudentDao
import com.example.teacherassistant.model.Student

class StudentRepository(private val studentDao: StudentDao) {

    val readAllData: LiveData<List<Student>> = studentDao.readAll()

    suspend fun addStudent(student: Student){
        studentDao.add(student)
    }

    suspend fun updateStudent(student: Student){
        studentDao.update(student)
    }

    suspend fun deleteStudent(student: Student){
        studentDao.delete(student)
    }

//    suspend fun deleteAllStudents(){
//        userDao.deleteAllStudent()
//    }

}