package com.iruda.recyclerviewexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.random.Random

class MainActivity : AppCompatActivity(), ExampleItemAdapter.OnItemClickListener {
    private val exampleList = generateList(500)
    private val adapter = ExampleItemAdapter(exampleList, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        val buttonInsert = findViewById<Button>(R.id.button_insert)
        val buttonDelete = findViewById<Button>(R.id.button_delete)

        buttonInsert.setOnClickListener {
            val index = Random.nextInt(8)

            val newItem = ExampleItem(
                R.drawable.ic_baseline_cake_24,
                "New item at position $index",
                "Line 2"
            )

            exampleList.add(index, newItem)
            adapter.notifyItemInserted(index)
        }

        buttonDelete.setOnClickListener {
            val index = Random.nextInt(8)

            exampleList.removeAt(index)
            adapter.notifyItemRemoved(index)
        }
    }

    override fun onItemClick(position: Int) {
        Toast.makeText(this, "Item $position clicked!", Toast.LENGTH_SHORT).show()
        val clickedItem: ExampleItem = exampleList[position]
        clickedItem.textOne = "Item $position clicked!"
        adapter.notifyItemChanged(position)
    }

    private fun generateList(size: Int): ArrayList<ExampleItem> {
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