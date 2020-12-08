package com.example.teacherassistant.view

import android.app.AlertDialog
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
import kotlinx.android.synthetic.main.fr_edit_student.*
import kotlinx.android.synthetic.main.fr_edit_student.view.*

class EditStudent : Fragment() {

    private lateinit var studentViewModel: StudentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fr_edit_student, container, false)

        studentViewModel = ViewModelProvider(this).get(StudentViewModel::class.java)

        view.es_first_name_et.setText(AppState.updateStudent.firstName)
        view.es_last_name_et.setText(AppState.updateStudent.lastName)

        view.es_delete_student_btn.setOnClickListener{
            deleteUser()
        }
        view.es_update_student_btn.setOnClickListener{
            updateItem()
        }
        // Inflate the layout for this fragment
        return view
    }

    private fun deleteUser() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Yes") { _, _ ->
            studentViewModel.deleteStudent(AppState.updateStudent)
            Toast.makeText(
                requireContext(),
                "Successfully removed: ${AppState.updateStudent.firstName}",
                Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_editStudent_to_studentList)
        }
        builder.setNegativeButton("No") { _, _ -> }
        builder.setTitle("Delete ${AppState.updateStudent.firstName} ${AppState.updateStudent.lastName}?")
        builder.setMessage("Are you sure you want to delete ${AppState.updateStudent.firstName}?")
        builder.create().show()
    }

    private fun inputCheck(firstName: String, lastName: String): Boolean{
        return !(TextUtils.isEmpty(firstName) && TextUtils.isEmpty(lastName))
    }

    private fun updateItem() {
        val firstName = es_first_name_et.text.toString()
        val lastName = es_last_name_et.text.toString()

        if (inputCheck(firstName, lastName)) {
            // Create User Object
            val updatedUser = Student(AppState.updateStudent.id, firstName, lastName)
            // Update Current User
            studentViewModel.updateStudent(updatedUser)
            Toast.makeText(requireContext(), "Updated Successfully!", Toast.LENGTH_SHORT).show()
            // Navigate Back
            findNavController().navigate(R.id.action_editStudent_to_studentList)
        } else {
            Toast.makeText(requireContext(), "Please fill out all fields.", Toast.LENGTH_SHORT)
                .show()
        }
    }
}