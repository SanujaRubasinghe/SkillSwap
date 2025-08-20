package com.example.skillswap

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MainAdapter(private val layouts: List<Int>):
    RecyclerView.Adapter<MainAdapter.MainViewHolder>(){

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MainViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(viewType, parent, false)
        return MainViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: MainViewHolder,
        position: Int
    ) {

    }

    override fun getItemCount(): Int {
        return layouts.size
    }

    inner class MainViewHolder(val view: View): RecyclerView.ViewHolder(view)


}