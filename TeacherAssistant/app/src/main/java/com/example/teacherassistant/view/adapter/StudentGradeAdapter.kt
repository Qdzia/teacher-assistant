package com.example.teacherassistant.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.teacherassistant.AppState
import com.example.teacherassistant.R
import com.example.teacherassistant.model.Participant
import com.example.teacherassistant.model.Student
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

//        holder.itemView.row_s_layout.setOnClickListener {
//            AppState.updateStudent = currentItem
//            holder.itemView.findNavController().navigate(R.id.action_studentList_to_editStudent)
//        }
    }

    fun setData(students: List<Student>){
        this.studentList = students
        notifyDataSetChanged()
    }
}