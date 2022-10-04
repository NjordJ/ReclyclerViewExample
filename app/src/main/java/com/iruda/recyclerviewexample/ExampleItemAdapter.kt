package com.iruda.recyclerviewexample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ExampleItemAdapter(private val exampleList: List<ExampleItem>) : RecyclerView.Adapter<ExampleItemAdapter.ExampleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExampleViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.example_item,
        parent, false)

        return ExampleViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ExampleViewHolder, position: Int) {
        val currentItem: ExampleItem = exampleList[position]

        holder.imageView.setImageResource(currentItem.imageResource)
        holder.textViewOne.text = currentItem.textOne
        holder.textViewTwo.text = currentItem.textTwo
    }

    override fun getItemCount() = exampleList.size

    class ExampleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.image_view)
        val textViewOne: TextView = itemView.findViewById(R.id.text_view_1)
        val textViewTwo: TextView = itemView.findViewById(R.id.text_view_2)
    }
}