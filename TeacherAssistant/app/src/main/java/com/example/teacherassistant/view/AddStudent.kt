package com.example.teacherassistant.view

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
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
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fr_add_student, container, false)

        studentViewModel = ViewModelProvider(this).get(StudentViewModel::class.java)

        view.toStudentListButton.setOnClickListener {
            insertDataToDatabase()
            //findNavController().navigate(R.id.action_addStudent_to_studentList)
        }

        return view
    }

    private fun insertDataToDatabase() {
        val firstName = firstNameEditText.text.toString()
        val lastName = lastNameEditText.text.toString()

        if(inputCheck(firstName, lastName)){
            // Create User Object
            val student = Student(
                0,
                firstName,
                lastName)
            // Add Data to Database
            studentViewModel.addStudent(student)
            Toast.makeText(requireContext(), "Successfully added!", Toast.LENGTH_LONG).show()
            // Navigate Back
            findNavController().navigate(R.id.action_addStudent_to_studentList)
        }else{
            Toast.makeText(requireContext(), "Please fill out all fields.", Toast.LENGTH_LONG).show()
        }
    }

    private fun inputCheck(firstName: String, lastName: String): Boolean{
        return !(TextUtils.isEmpty(firstName) && TextUtils.isEmpty(lastName))
    }


    companion object { fun newInstance()=
        AddStudent()
    }

}