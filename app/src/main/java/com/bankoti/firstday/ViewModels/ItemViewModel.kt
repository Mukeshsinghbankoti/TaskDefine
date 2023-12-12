package com.bankoti.firstday.ViewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bankoti.firstday.Models.Item

class ItemViewModel : ViewModel() {

    private val  _items= MutableLiveData<List<Item>>()

    val items: LiveData<List<Item>> get() = _items

 /*   init {
        // Simulate data loading
        _items.value = listOf(
            Item(1,"Item 1"),
            Item(2,"Item 2"),
            Item(3,"Item 3"),
            Item(4,"Item 4"),

            // Add more items as needed
        )
    }*/
}