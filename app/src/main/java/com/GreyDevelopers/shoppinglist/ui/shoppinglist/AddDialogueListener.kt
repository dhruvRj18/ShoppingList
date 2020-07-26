package com.GreyDevelopers.shoppinglist.ui.shoppinglist

import com.GreyDevelopers.shoppinglist.data.db.entities.ShoppingItem

interface AddDialogueListener {
    fun onAddButtonClicked(item: ShoppingItem)

}