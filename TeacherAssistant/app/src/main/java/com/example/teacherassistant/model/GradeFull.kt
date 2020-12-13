package com.example.teacherassistant.model

import androidx.room.Embedded

data class GradeFull(
    @Embedded(prefix = "s_")
    var student: Student,

    @Embedded(prefix = "c_")
    var course: Course,

    @Embedded
    var grade: Grade

)