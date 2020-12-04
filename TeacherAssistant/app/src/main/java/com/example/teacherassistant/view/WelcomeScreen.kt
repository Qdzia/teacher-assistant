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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fr_welcome_screen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        toCoursesListButton.setOnClickListener {
                view->view.findNavController().navigate(R.id.action_welcomeScreen_to_courseList)
        }
        toStudentsListButton.setOnClickListener {
                view->view.findNavController().navigate(R.id.action_welcomeScreen_to_studentList)
        }
        toReportButton.setOnClickListener {
                view->view.findNavController().navigate(R.id.action_welcomeScreen_to_report)
        }
    }

    companion object { fun newInstance()=
        WelcomeScreen()
    }
}