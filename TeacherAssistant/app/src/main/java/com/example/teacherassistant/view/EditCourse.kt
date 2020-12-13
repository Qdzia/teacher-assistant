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
import com.example.teacherassistant.model.Course
import com.example.teacherassistant.model.Student
import com.example.teacherassistant.view_model.CourseViewModel
import kotlinx.android.synthetic.main.fr_edit_course.*
import kotlinx.android.synthetic.main.fr_edit_course.view.*


class EditCourse : Fragment() {

    private lateinit var courseViewModel: CourseViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fr_edit_course, container, false)

        courseViewModel = ViewModelProvider(requireActivity()).get(CourseViewModel::class.java)

        view.ec_course_name_et.setText(AppState.activeCourse.courseName)

        view.ec_delete_course_btn.setOnClickListener{
            deleteUser()
        }
        view.ec_update_course_btn.setOnClickListener{
            updateItem()
        }

        return view
    }

    private fun deleteUser() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Yes") { _, _ ->
            courseViewModel.deleteCourse(AppState.activeCourse)
            Toast.makeText(
                requireContext(),
                "Successfully removed: ${AppState.updateStudent.firstName}",
                Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_editCourse_to_courseList)
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
        val courseName = ec_course_name_et.text.toString()

        if (courseName.isNotEmpty()) {
            // Create User Object
            val course = Course(AppState.activeCourse.id,courseName)
            AppState.activeCourse = course
            // Update Current User
            courseViewModel.updateCourse(course)
            Toast.makeText(requireContext(), "Updated Successfully!", Toast.LENGTH_SHORT).show()
            // Navigate Back
            findNavController().navigate(R.id.action_editCourse_to_courseStudent)
        } else {
            Toast.makeText(requireContext(), "Please fill out all fields.", Toast.LENGTH_SHORT)
                .show()
        }
    }


}