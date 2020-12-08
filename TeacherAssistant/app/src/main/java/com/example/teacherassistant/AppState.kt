package com.example.teacherassistant

import com.example.teacherassistant.model.Student

class AppState {

    companion object{
        var updateStudentName: String = ""
        var updateStudentLast: String = ""
        var updateStudent: Student = Student(0,"","")
    }
}