package com.example.teacherassistant.view.adapter

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.teacherassistant.AppState
import com.example.teacherassistant.R
import com.example.teacherassistant.model.Student
import com.example.teacherassistant.view.AddStudent
import kotlinx.android.synthetic.main.row_student.view.*


class StudentListAdapter: RecyclerView.Adapter<StudentListAdapter.MyViewHolder>() {

    private var studentList = emptyList<Student>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.row_student,
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
        holder.itemView.row_s_id_tv.text = currentItem.id.toString()
        holder.itemView.row_s_first_name_tv.text = currentItem.firstName
        holder.itemView.row_s_last_name_tv.text = currentItem.lastName

        holder.itemView.row_s_layout.setOnClickListener {
            AppState.activeStudent = currentItem
            holder.itemView.findNavController().navigate(R.id.action_studentList_to_studentInfo)
        }
    }

    fun setData(students: List<Student>){
        this.studentList = students
        notifyDataSetChanged()
    }
}