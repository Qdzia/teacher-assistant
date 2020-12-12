package com.example.teacherassistant

import com.example.teacherassistant.model.Course
import com.example.teacherassistant.model.Student

class AppState {

    companion object{
        var updateStudent: Student = Student(0,"error","massage")
        var studentsToAdd: MutableList<Student> = arrayListOf()
        var activeCourse: Course = Course(0,"error massage")
        var activeStudent: Student = Student(0,"error","massage")


    }
}