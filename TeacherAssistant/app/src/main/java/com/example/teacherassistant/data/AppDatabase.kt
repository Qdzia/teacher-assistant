package com.example.teacherassistant.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.teacherassistant.model.Course
import com.example.teacherassistant.model.Grade
import com.example.teacherassistant.model.Participant
import com.example.teacherassistant.model.Student

@Database(entities = [Student::class,Course::class,Grade::class,Participant::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun studentDao(): StudentDao
    abstract fun courseDao(): CourseDao
    abstract fun gradeDao(): GradeDao
    abstract fun participantDao(): ParticipantDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "MyDatabase"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }

}