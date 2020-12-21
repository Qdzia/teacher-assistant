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
import com.example.teacherassistant.view_model.CourseViewModel
import kotlinx.android.synthetic.main.fr_course_list.view.*
import kotlinx.android.synthetic.main.fr_student_info.view.*

class StudentInfo : Fragment() {

    private lateinit var courseViewModel: CourseViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fr_student_info, container, false)

        AppState.isCourseList = false

        view.si_student_name_tv.text = "${AppState.activeStudent.firstName} ${AppState.activeStudent.lastName}"
        // Recyclerview
        val adapter = CourseListAdapter()
        val recyclerView = view.si_courses_rv
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // UserViewModel
        courseViewModel = ViewModelProvider(requireActivity()).get(CourseViewModel::class.java)
        courseViewModel.readAllCourses.observe(viewLifecycleOwner, Observer { course ->
            adapter.setData(course)
        })

        view.si_back_img.setOnClickListener{
            findNavController().navigate(R.id.action_studentInfo_to_studentList)
        }

        return view
    }

}