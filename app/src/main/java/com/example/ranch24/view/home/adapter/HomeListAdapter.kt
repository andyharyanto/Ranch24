package com.example.ranch24.view.home.adapter

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ranch24.R
import com.example.ranch24.model.home.HomeData

class HomeListAdapter : RecyclerView.Adapter<HomeListAdapter.ListViewHolder>() {

    private var listHomeData = ArrayList<HomeData>()

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var llItemHome: LinearLayout = itemView.findViewById(R.id.llItemHome)
        var tvName: TextView = itemView.findViewById(R.id.tvName)
        var tvYear: TextView = itemView.findViewById(R.id.tvYear)
        var tvValue: TextView = itemView.findViewById(R.id.tvValue)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.adapter_home_list, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listHomeData.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = listHomeData[position]

        holder.llItemHome.setBackgroundColor(Color.parseColor(data.color))
        holder.tvName.text = data.name
        holder.tvYear.text = data.year.toString()
        holder.tvValue.text = data.pantoneValue
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(data: ArrayList<HomeData>) {
        listHomeData = data
        notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun clearData() {
        listHomeData.clear()
        notifyDataSetChanged()
    }
}