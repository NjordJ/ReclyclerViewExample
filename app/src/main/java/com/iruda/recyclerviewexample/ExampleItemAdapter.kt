package com.iruda.recyclerviewexample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ExampleItemAdapter(private val exampleList: List<ExampleItem>,
    private val listener: OnItemClickListener) :
    RecyclerView.Adapter<ExampleItemAdapter.ExampleViewHolder>() {

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

    inner class ExampleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
    View.OnClickListener{
        val imageView: ImageView = itemView.findViewById(R.id.image_view)
        val textViewOne: TextView = itemView.findViewById(R.id.text_view_1)
        val textViewTwo: TextView = itemView.findViewById(R.id.text_view_2)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            val position: Int = adapterPosition
            if(position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)
            }
        }
    }
    
    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }
}