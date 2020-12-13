package com.example.teacherassistant.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.teacherassistant.R
import com.example.teacherassistant.model.Grade
import kotlinx.android.synthetic.main.row_grade.view.*

class GradeAdapter: RecyclerView.Adapter<GradeAdapter.MyViewHolder>() {

    private var gradeList = emptyList<Grade>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.row_grade,
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

        holder.itemView.row_g_grade_tv.text = currentItem.grade.toString()
        holder.itemView.row_g_desc_tv.text = currentItem.description

        holder.itemView.row_g_delete_btn.setOnClickListener{

        }
    }

    fun setData(grades: List<Grade>){
        this.gradeList = grades
        notifyDataSetChanged()
    }
}