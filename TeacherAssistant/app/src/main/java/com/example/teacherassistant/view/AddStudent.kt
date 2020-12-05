package com.example.teacherassistant.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.teacherassistant.R
import kotlinx.android.synthetic.main.fr_add_student.view.*

class AddStudent : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fr_add_student, container, false)

        view.toStudentListButton.setOnClickListener {
            findNavController().navigate(R.id.action_addStudent_to_studentList)
        }
        return view
    }

    companion object { fun newInstance()=
        AddStudent()
    }

}