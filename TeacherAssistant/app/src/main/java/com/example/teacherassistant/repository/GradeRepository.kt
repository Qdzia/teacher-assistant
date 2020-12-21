package com.example.teacherassistant.repository

import androidx.lifecycle.LiveData
import com.example.teacherassistant.data.GradeDao
import com.example.teacherassistant.model.Grade
import com.example.teacherassistant.model.GradeFull
import java.util.*


class GradeRepository(private val gradeDao: GradeDao) {

    val readAll: LiveData<List<Grade>> = gradeDao.readAll()
    val readFullTodayGrades: LiveData<List<GradeFull>> = gradeDao.readFullTodayGrades()


    suspend fun addGrade(grade: Grade){
        gradeDao.add(grade)
    }

    suspend fun deleteGrade(grade: Grade){
        gradeDao.delete(grade)
    }

    fun readFromStudentCourse(studentId: Int,courseId:Int) : LiveData<List<Grade>> {
        return gradeDao.readFromStudentCourse(studentId,courseId)
    }

}