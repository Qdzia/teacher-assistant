package com.example.teacherassistant.view

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.teacherassistant.AppState
import com.example.teacherassistant.R
import com.example.teacherassistant.model.Course
import com.example.teacherassistant.model.Student
import com.example.teacherassistant.view.adapter.StudentSelectionAdapter
import com.example.teacherassistant.view_model.CourseViewModel
import com.example.teacherassistant.view_model.StudentViewModel
import kotlinx.android.synthetic.main.fr_add_course.*
import kotlinx.android.synthetic.main.fr_add_course.view.*

class AddCourse : Fragment() {

    private lateinit var courseViewModel: CourseViewModel
    private lateinit var studentViewModel: StudentViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fr_add_course, container, false)

        courseViewModel = ViewModelProvider(this).get(CourseViewModel::class.java)

        attachStudentRecycleView(view)

        view.ac_add_course_btn.setOnClickListener {
            //insertDataToDatabase()
            //Toast.makeText(requireContext(), " Test", Toast.LENGTH_LONG).show()
            insertParticipants("Logic")
        }

        return view
    }

    private fun insertDataToDatabase() {
        val courseName = ac_course_name_et.text.toString()

        if(inputCheck(courseName)){
            val course = Course(0,courseName)
            courseViewModel.addCourse(course)
            insertParticipants(courseName)
            Toast.makeText(requireContext(), "Successfully added!", Toast.LENGTH_LONG).show()

            findNavController().navigate(R.id.action_addCourse_to_courseList)
        }else{
            Toast.makeText(requireContext(), "Please fill out all fields.", Toast.LENGTH_LONG).show()
        }
    }

    private fun inputCheck(name: String): Boolean{
        return !(TextUtils.isEmpty(name))
    }

    private fun attachStudentRecycleView(view: View){

        // Recyclerview
        val adapter = StudentSelectionAdapter()
        val recyclerView = view.ac_students_rv
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // UserViewModel
        studentViewModel = ViewModelProvider(this).get(StudentViewModel::class.java)
        studentViewModel.readAllData.observe(viewLifecycleOwner, Observer { student ->
            adapter.setData(student)
        })
    }

    private fun insertParticipants(courseName: String){

        val course :Course  = courseViewModel.getCourseByName(courseName)
        Log.e("Course Test"," ${course.courseName}")
        Toast.makeText(requireContext(), "${courseName} + ${courseName}", Toast.LENGTH_LONG).show()
        //courseViewModel.addStudentsToCourse(AppState.studentsToAdd,course)
    }
}