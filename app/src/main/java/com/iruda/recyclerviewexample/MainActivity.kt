package com.iruda.recyclerviewexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val exampleList = generateList(500)

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.adapter = ExampleItemAdapter(exampleList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
    }

    private fun generateList(size: Int): List<ExampleItem> {
        val list = ArrayList<ExampleItem>()

        for(i in 0 until size){
            val drawable = when (i % 3) {
                0 -> R.drawable.ic_baseline_cake_24
                1 -> R.drawable.ic_baseline_adb_24
                else -> R.drawable.ic_baseline_accessibility_24
            }

            val item = ExampleItem(textOne = "Item $i", textTwo = "Line 2", imageResource = drawable)
            list += item
        }

        return list
    }

}