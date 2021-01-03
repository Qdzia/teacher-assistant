package com.example.teacherassistant.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.teacherassistant.R
import com.example.teacherassistant.view.adapter.StudentListAdapter
import com.example.teacherassistant.view_model.StudentViewModel
import kotlinx.android.synthetic.main.fr_course_list.view.*
import kotlinx.android.synthetic.main.fr_student_list.view.*

class StudentList : Fragment() {

    private lateinit var studentViewModel: StudentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fr_student_list, container, false)

        // Recyclerview
        val adapter = StudentListAdapter(R.id.action_studentList_to_studentInfo)
        val recyclerView = view.sl_students_rv
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // UserViewModel
        studentViewModel = ViewModelProvider(requireActivity()).get(StudentViewModel::class.java)
        studentViewModel.readAllData.observe(viewLifecycleOwner, Observer { student ->
            adapter.setData(student)
        })

        view.sl_to_add_student.setOnClickListener {
            findNavController().navigate(R.id.action_studentList_to_addStudent)
        }
        view.sl_back_img.setOnClickListener{
            findNavController().navigate(R.id.action_studentList_to_welcomeScreen)
        }

        return view;
    }
}