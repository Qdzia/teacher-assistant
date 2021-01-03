package com.example.teacherassistant.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.teacherassistant.AppState
import com.example.teacherassistant.R
import com.example.teacherassistant.view.adapter.StudentGradeAdapter
import com.example.teacherassistant.view_model.ParticipantViewModel
import kotlinx.android.synthetic.main.fr_course_student.view.*
import kotlinx.android.synthetic.main.fr_ranking.view.*


class Ranking : Fragment() {

    private lateinit var participantViewModel: ParticipantViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fr_ranking, container, false)

        // Recyclerview
        val adapter = StudentGradeAdapter()
        val recyclerView = view.rk_student_grade_rv
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        participantViewModel = ViewModelProvider(requireActivity()).get(ParticipantViewModel::class.java)
        participantViewModel.readFromCourseWithGrade(AppState.activeCourse).observe(viewLifecycleOwner, Observer { student ->
            adapter.setData(student)
        })

        return view
    }

}