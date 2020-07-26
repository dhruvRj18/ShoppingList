package com.GreyDevelopers.shoppinglist.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.GreyDevelopers.shoppinglist.data.db.entities.ShoppingItem


@Dao
interface ShoppingDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateOrInsert(item: ShoppingItem)

    @Delete
    suspend fun delete(item: ShoppingItem)

    @Query("SELECT * FROM shopping_item")
    fun getAllItems():  LiveData<List<ShoppingItem>>
}