package com.GreyDevelopers.shoppinglist.data.repositories

import com.GreyDevelopers.shoppinglist.data.db.ShoppingDatabase
import com.GreyDevelopers.shoppinglist.data.db.entities.ShoppingItem

class ShoppingRepository(
    private val database: ShoppingDatabase
) {
    suspend fun updateOrInsert(item: ShoppingItem) = database.getShoppingDao().updateOrInsert(item)

    suspend fun delete(item: ShoppingItem) = database.getShoppingDao().delete(item)

    fun getAllItems() = database.getShoppingDao().getAllItems()
}