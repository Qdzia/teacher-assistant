package com.example.teacherassistant.view.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.teacherassistant.AppState
import com.example.teacherassistant.R
import com.example.teacherassistant.model.Participant
import com.example.teacherassistant.model.Student
import com.example.teacherassistant.model.StudentLastGrade
import kotlinx.android.synthetic.main.row_student_grade.view.*

class StudentGradeAdapter: RecyclerView.Adapter<StudentGradeAdapter.MyViewHolder>() {

    private var studentList = emptyList<Student>()

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
        holder.itemView.row_sg_first_name.text = currentItem.firstName
        holder.itemView.row_sg_last_name.text = currentItem.lastName

//        if(currentItem.grade != null){
//            holder.itemView.row_sg_grades.text = "Have Grade " + currentItem.grade?.grade.toString()
//        } else {
//            holder.itemView.row_sg_grades.text = "Needs Grade "
//        }

        holder.itemView.row_sg_layout.setOnClickListener {
            AppState.activeStudent = currentItem
            holder.itemView.findNavController().navigate(R.id.action_courseStudent_to_markStudent)
        }
    }

    fun setData(students: List<Student>){
        this.studentList = students
        notifyDataSetChanged()
    }
}