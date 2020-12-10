package com.example.teacherassistant.view

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.teacherassistant.R
import com.example.teacherassistant.model.Course
import com.example.teacherassistant.view_model.CourseViewModel
import kotlinx.android.synthetic.main.fr_add_course.*
import kotlinx.android.synthetic.main.fr_add_course.view.*

class AddCourse : Fragment() {

    private lateinit var courseViewModel: CourseViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fr_add_course, container, false)

        courseViewModel = ViewModelProvider(this).get(CourseViewModel::class.java)

        view.ac_add_course_btn.setOnClickListener {
            insertDataToDatabase()
        }
        // Inflate the layout for this fragment
        return view
    }

    private fun insertDataToDatabase() {
        val courseName = ac_course_name_et.text.toString()

        if(inputCheck(courseName)){
            val course = Course(0,courseName)
            courseViewModel.addCourse(course)
            Toast.makeText(requireContext(), "Successfully added!", Toast.LENGTH_LONG).show()

            findNavController().navigate(R.id.action_addCourse_to_courseList)
        }else{
            Toast.makeText(requireContext(), "Please fill out all fields.", Toast.LENGTH_LONG).show()
        }
    }

    private fun inputCheck(name: String): Boolean{
        return !(TextUtils.isEmpty(name))
    }

}