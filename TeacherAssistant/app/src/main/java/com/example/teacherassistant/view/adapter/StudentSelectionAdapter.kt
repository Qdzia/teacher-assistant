package com.example.teacherassistant.view.adapter

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.teacherassistant.AppState
import com.example.teacherassistant.R
import com.example.teacherassistant.model.Student
import kotlinx.android.synthetic.main.row_student.view.*


class StudentSelectionAdapter: RecyclerView.Adapter<StudentSelectionAdapter.MyViewHolder>() {

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
            selectItem(it,currentItem)
        }
    }

    fun setData(students: List<Student>){
        this.studentList = students
        notifyDataSetChanged()
    }

    fun selectItem(view: View,student:Student){

        var color = Color.TRANSPARENT
        val background: Drawable = view.background
        if (background is ColorDrawable) color = background.color

        if(color == Color.TRANSPARENT.toInt())
        {
            view.setBackgroundColor(Color.parseColor("#7751c2"));
            AppState.studentsToAdd.add(student)
        }else{
            view.setBackgroundColor(Color.TRANSPARENT);
            AppState.studentsToAdd.remove(student)
        }
    }
}