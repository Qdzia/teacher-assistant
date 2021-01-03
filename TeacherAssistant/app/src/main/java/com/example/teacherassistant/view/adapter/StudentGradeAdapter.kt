package com.example.teacherassistant.view.adapter

import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.widget.ImageViewCompat
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.teacherassistant.AppState
import com.example.teacherassistant.R
import com.example.teacherassistant.model.StudentLastGrade
import kotlinx.android.synthetic.main.row_student_grade.view.*

class StudentGradeAdapter(): RecyclerView.Adapter<StudentGradeAdapter.MyViewHolder>() {

    private var studentList = emptyList<StudentLastGrade>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.row_student_grade,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return studentList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = studentList[position]
        holder.itemView.row_sg_name_tv.text = currentItem.student.lastName
        holder.itemView.row_sg_grades.text = currentItem.grade.grade.toString()
        holder.itemView.row_sg_index_tv.text = (position+1).toString()

    }

    fun setData(students: List<StudentLastGrade>){
        this.studentList = students
        notifyDataSetChanged()
    }
}