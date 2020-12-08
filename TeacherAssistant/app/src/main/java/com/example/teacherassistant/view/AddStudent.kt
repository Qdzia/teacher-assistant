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
import com.example.teacherassistant.AppState
import com.example.teacherassistant.R
import com.example.teacherassistant.model.Student
import com.example.teacherassistant.view_model.StudentViewModel
import kotlinx.android.synthetic.main.fr_add_student.*
import kotlinx.android.synthetic.main.fr_add_student.view.*

class AddStudent : Fragment() {

    private lateinit var studentViewModel: StudentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fr_add_student, container, false)

        studentViewModel = ViewModelProvider(this).get(StudentViewModel::class.java)

        view.as_add_student_btn.setOnClickListener {
            insertDataToDatabase()
        }
        return view
    }

    private fun insertDataToDatabase() {
        val firstName = as_first_name_et.text.toString()
        val lastName = as_last_name_et.text.toString()

        if(inputCheck(firstName, lastName)){
            val student = Student(
                0,
                firstName,
                lastName)
            studentViewModel.addStudent(student)
            Toast.makeText(requireContext(), "Successfully added!", Toast.LENGTH_LONG).show()

            findNavController().navigate(R.id.action_addStudent_to_studentList)
        }else{
            Toast.makeText(requireContext(), "Please fill out all fields.", Toast.LENGTH_LONG).show()
        }
    }

    private fun inputCheck(firstName: String, lastName: String): Boolean{
        return !(TextUtils.isEmpty(firstName) && TextUtils.isEmpty(lastName))
    }

}