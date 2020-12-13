package com.example.teacherassistant.repository

import androidx.lifecycle.LiveData
import com.example.teacherassistant.data.GradeDao
import com.example.teacherassistant.model.Grade
import com.example.teacherassistant.model.GradeFull
import java.util.*


class GradeRepository(private val gradeDao: GradeDao) {

    val readAll: LiveData<List<Grade>> = gradeDao.readAll()
    val readFullTodayGrades: LiveData<List<GradeFull>> = gradeDao.readFullTodayGrades()


//    init {
//        val time = Calendar.getInstance()
//        time.time = Date()
//        time[Calendar.HOUR_OF_DAY] = 0
//        time[Calendar.MINUTE] = 0
//        time[Calendar.SECOND] = 0
//        time[Calendar.MILLISECOND] = 0
//        val begin = Date(time.timeInMillis)
//        time[Calendar.HOUR_OF_DAY] = 23
//        time[Calendar.MINUTE] = 59
//        time[Calendar.SECOND] = 59
//        time[Calendar.MILLISECOND] = 999
//        val end = Date(time.timeInMillis)
//        readFullTodayGrades = gradeDao.readFullTodayGrades(end,begin)
//    }

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