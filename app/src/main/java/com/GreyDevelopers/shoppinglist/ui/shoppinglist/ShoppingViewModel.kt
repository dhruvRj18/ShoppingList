package com.GreyDevelopers.shoppinglist.ui.shoppinglist

import androidx.lifecycle.ViewModel
import com.GreyDevelopers.shoppinglist.data.db.entities.ShoppingItem
import com.GreyDevelopers.shoppinglist.data.repositories.ShoppingRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShoppingViewModel (
    private val repository: ShoppingRepository
):   ViewModel(){

    fun updateOrInsert(item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.updateOrInsert(item)
    }

    fun delete(item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.delete(item)
    }

    fun getAllItems() = repository.getAllItems()

}