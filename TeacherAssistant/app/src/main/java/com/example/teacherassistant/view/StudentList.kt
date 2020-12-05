package com.example.teacherassistant.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.teacherassistant.R
import kotlinx.android.synthetic.main.fr_student_list.view.*

class StudentList : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fr_student_list, container, false)

        view.toAddStudent.setOnClickListener {
            findNavController().navigate(R.id.action_studentList_to_addStudent)
        }

        return view;
    }

    companion object { fun newInstance()=
        StudentList()
    }
}