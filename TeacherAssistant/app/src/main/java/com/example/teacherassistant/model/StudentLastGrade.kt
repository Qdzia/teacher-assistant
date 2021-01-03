package com.example.teacherassistant.model

import androidx.room.Embedded

class StudentLastGrade (

    @Embedded(prefix = "s_")
    var student: Student,

    @Embedded
    var grade: Grade
)