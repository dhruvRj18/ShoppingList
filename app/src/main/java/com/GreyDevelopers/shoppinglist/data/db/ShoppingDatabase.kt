package com.GreyDevelopers.shoppinglist.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.GreyDevelopers.shoppinglist.data.db.entities.ShoppingItem

@Database(
    entities = [ShoppingItem::class],
    version = 1
)
abstract class ShoppingDatabase : RoomDatabase() {
    abstract fun getShoppingDao(): ShoppingDao

    companion object {
        @Volatile
        private var instance: ShoppingDatabase? = null
        private var LOCK = Any()


        operator fun invoke(context: Context) = instance
            ?: synchronized(LOCK){
            instance
                ?: createDatabse(
                    context
                )
                    .also { instance = it }
        }
        private fun createDatabse(context: Context) =
            Room.databaseBuilder(context.applicationContext,
                ShoppingDatabase::class.java,"ShppingDb.db").build()
    }


}