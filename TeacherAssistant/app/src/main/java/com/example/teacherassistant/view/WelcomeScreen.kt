package com.example.teacherassistant.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.teacherassistant.R
import kotlinx.android.synthetic.main.fr_welcome_screen.*

class WelcomeScreen : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fr_welcome_screen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ws_to_course_list.setOnClickListener {
                view->view.findNavController().navigate(R.id.action_welcomeScreen_to_courseList)
        }
        ws_to_student_list.setOnClickListener {
                view->view.findNavController().navigate(R.id.action_welcomeScreen_to_studentList)
        }
        ws_to_report.setOnClickListener {
                view->view.findNavController().navigate(R.id.action_welcomeScreen_to_report)
        }
    }

    companion object { fun newInstance()=
        WelcomeScreen()
    }
}