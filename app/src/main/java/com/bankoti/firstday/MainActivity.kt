package com.bankoti.firstday

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bankoti.firstday.Models.Item
import com.bankoti.firstday.ViewModels.ItemViewModel
import com.bankoti.firstday.Views.ItemAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var itemViewModel: ItemViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        val data = ArrayList<Item>()


        for (i in 1..20) {
            data.add(Item(i, "Item " + i))
        }
        val adapter = ItemAdapter(data) // You can initialize it with an empty list initially
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        itemViewModel = ViewModelProvider(this).get(ItemViewModel::class.java)


        itemViewModel.items.observe(this, Observer { items ->
            items?.let {
              adapter.notifyDataSetChanged()
            }
        })
    }
}


