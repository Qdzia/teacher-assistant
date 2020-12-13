package com.example.teacherassistant.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.time.LocalDateTime

@Entity(tableName = "grade_table",
    foreignKeys = [
        ForeignKey(
            entity = Student::class,
            parentColumns = ["id"],
            childColumns = ["student_id"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Course::class,
            parentColumns = ["id"],
            childColumns = ["course_id"],
            onDelete = ForeignKey.CASCADE
        )
    ])
data class Grade(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val course_id: Int,
    val student_id: Int,
    val grade: Double,
    val description: String,
    val date: String
)