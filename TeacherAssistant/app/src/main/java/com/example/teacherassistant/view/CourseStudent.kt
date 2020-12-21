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
import com.example.teacherassistant.model.Course
import com.example.teacherassistant.view.adapter.StudentGradeAdapter
import com.example.teacherassistant.view_model.CourseViewModel
import com.example.teacherassistant.view_model.ParticipantViewModel
import com.example.teacherassistant.view_model.StudentViewModel
import kotlinx.android.synthetic.main.fr_course_list.view.*
import kotlinx.android.synthetic.main.fr_course_student.view.*

class CourseStudent : Fragment() {

    private lateinit var participantViewModel: ParticipantViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fr_course_student, container, false)

        // Recyclerview
        val adapter = StudentGradeAdapter()
        val recyclerView = view.cs_student_grade_rv
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // UserViewModel
        participantViewModel = ViewModelProvider(requireActivity()).get(ParticipantViewModel::class.java)
        participantViewModel.readParticipantFromCourse(AppState.activeCourse).observe(viewLifecycleOwner, Observer { student ->
            adapter.setData(student)
        })

        view.cs_course_name_tv.text = AppState.activeCourse.courseName

        view.cs_edit_course_btn.setOnClickListener {
            findNavController().navigate(R.id.action_courseStudent_to_editCourse)
        }

        view.cs_to_add_course_student.setOnClickListener {
            findNavController().navigate(R.id.action_courseStudent_to_addCourseStudent)
        }

        view.cs_back_img.setOnClickListener{
            findNavController().navigate(R.id.action_courseStudent_to_courseList)
        }

        return view
    }

}