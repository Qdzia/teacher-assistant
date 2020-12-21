package com.example.teacherassistant.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.teacherassistant.R
import com.example.teacherassistant.view.adapter.GradeRaportAdapter
import com.example.teacherassistant.view_model.GradeViewModel
import com.example.teacherassistant.view_model.StudentViewModel
import kotlinx.android.synthetic.main.fr_course_list.view.*
import kotlinx.android.synthetic.main.fr_report.view.*

class Report : Fragment() {

    private lateinit var gradeViewModel: GradeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fr_report, container, false)
        // Recyclerview
        val adapter = GradeRaportAdapter()
        val recyclerView = view.r_grades_rv
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // UserViewModel
        gradeViewModel = ViewModelProvider(requireActivity()).get(GradeViewModel::class.java)
        gradeViewModel.readFullTodayGrades.observe(viewLifecycleOwner, Observer { grade ->
            adapter.setData(grade)
        })

        view.r_back_img.setOnClickListener {
                findNavController().navigate(R.id.action_report_to_welcomeScreen)
        }
        return view
    }


}