package com.example.teacherassistant.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.teacherassistant.AppState
import com.example.teacherassistant.R
import kotlinx.android.synthetic.main.fr_edit_student.view.*

class EditStudent : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fr_edit_student, container, false)
        view.es_first_name_et.setText(AppState.updateStudentName)
        view.es_last_name_et.setText(AppState.updateStudentLast)

        // Inflate the layout for this fragment
        return view
    }

}