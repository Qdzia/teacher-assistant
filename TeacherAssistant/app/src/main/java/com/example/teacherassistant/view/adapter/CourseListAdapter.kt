package com.example.teacherassistant.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.teacherassistant.AppState
import com.example.teacherassistant.R
import com.example.teacherassistant.model.Course
import kotlinx.android.synthetic.main.row_course.view.*

class CourseListAdapter: RecyclerView.Adapter<CourseListAdapter.MyViewHolder>() {

    private var courseList = emptyList<Course>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.row_course,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return courseList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = courseList[position]
        holder.itemView.row_c_id_tv.text = currentItem.id.toString()
        holder.itemView.row_c_name_tv.text = currentItem.courseName

        holder.itemView.row_c_layout.setOnClickListener {
            //AppState.updateStudent = currentItem
            AppState.activeCourse = currentItem
            holder.itemView.findNavController().navigate(R.id.action_courseList_to_courseStudent)
        }
    }

    fun setData(courses: List<Course>){
        this.courseList = courses
        notifyDataSetChanged()
    }
}