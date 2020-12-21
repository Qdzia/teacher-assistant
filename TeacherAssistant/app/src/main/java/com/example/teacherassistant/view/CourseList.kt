package com.example.teacherassistant.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.teacherassistant.AppState
import com.example.teacherassistant.R
import com.example.teacherassistant.view.adapter.CourseListAdapter
import com.example.teacherassistant.view.adapter.StudentListAdapter
import com.example.teacherassistant.view_model.CourseViewModel
import com.example.teacherassistant.view_model.StudentViewModel
import kotlinx.android.synthetic.main.fr_course_list.view.*
import kotlinx.android.synthetic.main.fr_student_list.view.*

class CourseList : Fragment() {

    private lateinit var courseViewModel: CourseViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view  = inflater.inflate(R.layout.fr_course_list, container, false)

        AppState.isCourseList = true

        // Recyclerview
        val adapter = CourseListAdapter()
        val recyclerView = view.cl_courses_rv
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // UserViewModel
        courseViewModel = ViewModelProvider(requireActivity()).get(CourseViewModel::class.java)
        courseViewModel.readAllCourses.observe(viewLifecycleOwner, Observer { course ->
            adapter.setData(course)
        })

        view.cl_to_add_course.setOnClickListener {
            findNavController().navigate(R.id.action_courseList_to_addCourse)
        }
        view.cl_back_img.setOnClickListener{
            findNavController().navigate(R.id.action_courseList_to_welcomeScreen)
        }



        return view
    }
}