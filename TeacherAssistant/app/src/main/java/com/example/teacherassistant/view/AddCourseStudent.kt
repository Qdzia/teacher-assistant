package com.example.teacherassistant.view

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.teacherassistant.AppState
import com.example.teacherassistant.R
import com.example.teacherassistant.model.Course
import com.example.teacherassistant.model.Participant
import com.example.teacherassistant.view.adapter.StudentSelectionAdapter
import com.example.teacherassistant.view_model.CourseViewModel
import com.example.teacherassistant.view_model.ParticipantViewModel
import com.example.teacherassistant.view_model.StudentViewModel
import kotlinx.android.synthetic.main.fr_add_course_student.view.*

class AddCourseStudent : Fragment() {

    private lateinit var courseViewModel: CourseViewModel
    private lateinit var studentViewModel: StudentViewModel
    private lateinit var participantViewModel: ParticipantViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fr_add_course_student, container, false)

        AppState.studentsToAdd.clear()

        // Recyclerview
        val adapter = StudentSelectionAdapter()
        val recyclerView = view.acs_students_rv
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // UserViewModel
        courseViewModel = ViewModelProvider(requireActivity()).get(CourseViewModel::class.java)
        studentViewModel = ViewModelProvider(requireActivity()).get(StudentViewModel::class.java)
        participantViewModel = ViewModelProvider(requireActivity()).get(ParticipantViewModel::class.java)

        studentViewModel.readAllData.observe(viewLifecycleOwner, Observer { student ->
            adapter.setData(student)
        })



        view.acs_add_btn.setOnClickListener {

            participantViewModel.deleteAllParticipantFromCourse(AppState.activeCourse.id)
            participantViewModel.addParticipants(AppState.studentsToAdd,AppState.activeCourse)

            findNavController().navigate(R.id.action_addCourseStudent_to_courseStudent)
//            participantViewModel.readAll.value?.forEach{
//                Log.e("Participant:"," s: ${it.student_id} c: ${it.course_id}")
//            }
            //insertDataToDatabase()
//            courseViewModel.readAllParticipant.forEach {
//                Log.e("Participant:","c: ${it.course_id} s: ${it.student_id}\"")
//            }
//            courseViewModel.readParticipantFromCourse(AppState.activeCourse).value?.forEach {
//                Log.e("Participant:","${it.firstName}")
//            }

        }

        return view
    }

    private fun insertDataToDatabase() {

        if (AppState.studentsToAdd.isNotEmpty()) {

            courseViewModel.addStudentsToCourse(AppState.studentsToAdd,AppState.activeCourse)
            AppState.studentsToAdd.clear()
            Toast.makeText(requireContext(), "Successfully added!", Toast.LENGTH_LONG).show()

            findNavController().navigate(R.id.action_addCourseStudent_to_courseStudent)
        } else {
            Toast.makeText(requireContext(), "Please fill out all fields.", Toast.LENGTH_LONG)
                .show()
        }
    }

    private fun inputCheck(name: String): Boolean {
        return !(TextUtils.isEmpty(name))
    }




}