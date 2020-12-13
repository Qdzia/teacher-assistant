package com.example.teacherassistant.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.teacherassistant.AppState
import com.example.teacherassistant.R
import com.example.teacherassistant.model.Grade
import com.example.teacherassistant.model.GradeFull
import com.example.teacherassistant.model.Student
import kotlinx.android.synthetic.main.row_grade_raport.view.*
import kotlinx.android.synthetic.main.row_student_grade.view.*


class GradeRaportAdapter: RecyclerView.Adapter<GradeRaportAdapter.MyViewHolder>() {

    private var gradeList = emptyList<GradeFull>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.row_grade_raport,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return gradeList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = gradeList[position]

        holder.itemView.row_gr_grade_tv.text = currentItem.grade.grade.toString()
        holder.itemView.row_gr_student_info_tv.text = currentItem.student.firstName//"${currentItem.student.firstName} ${currentItem.student.lastName}"
        holder.itemView.row_gr_course_name_tv.text = currentItem.course.courseName
        holder.itemView.row_gr_date_tv.text = currentItem.grade.date
        holder.itemView.row_gr_desc_tv.text = currentItem.grade.description

    }

    fun setData(grades: List<GradeFull>){
        this.gradeList = grades
        notifyDataSetChanged()
    }
}