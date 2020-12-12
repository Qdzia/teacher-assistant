package com.example.teacherassistant.view

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.teacherassistant.AppState
import com.example.teacherassistant.R
import com.example.teacherassistant.model.Grade
import com.example.teacherassistant.view_model.StudentViewModel
import kotlinx.android.synthetic.main.fr_mark_student.*
import kotlinx.android.synthetic.main.fr_mark_student.view.*
import java.time.LocalDateTime

class MarkStudent : Fragment() {

    private lateinit var studentViewModel: StudentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fr_mark_student, container, false)

        view.ms_student_info_tv.text = "${AppState.updateStudent.firstName} ${AppState.updateStudent.lastName}"

        view.ms_submit_btn.setOnClickListener {
            //insertDataToDatabase()
        }

        return view
    }

    private fun insertDataToDatabase() {
        val grade = ms_grade_etdn.text.toString().toDouble()
        val desc = ms_desc_etml.text.toString()

        if(inputCheck(grade,desc)){
            val gradeObj = Grade(0,
                AppState.activeCourse.id,
                AppState.activeStudent.id,
                grade,
                desc,
                LocalDateTime.now().toString()
            )

            studentViewModel.addGrade(gradeObj)
            Toast.makeText(requireContext(), "Successfully added!", Toast.LENGTH_LONG).show()

            findNavController().navigate(R.id.action_addCourse_to_courseList)
        }else{
            Toast.makeText(requireContext(), "Please fill out all fields.", Toast.LENGTH_LONG).show()
        }
    }

    private fun inputCheck(grade: Double,desc:String): Boolean{
        return !(TextUtils.isEmpty(desc) && grade>0 && grade<=6)
    }
}