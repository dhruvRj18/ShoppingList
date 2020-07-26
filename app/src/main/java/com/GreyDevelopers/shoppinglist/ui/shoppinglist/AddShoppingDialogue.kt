package com.GreyDevelopers.shoppinglist.ui.shoppinglist

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.GreyDevelopers.shoppinglist.R
import com.GreyDevelopers.shoppinglist.data.db.entities.ShoppingItem
import kotlinx.android.synthetic.main.dialogue_add_item.*

class AddShoppingDialogue(context: Context,var addDialogueListener: AddDialogueListener):AppCompatDialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialogue_add_item)
        btnAdd.setOnClickListener {
            val name = addItem.text.toString()
            val amount = addAmount.text.toString()

            if (name.isEmpty() || amount.isEmpty()){
                Toast.makeText(context, "Please Enter all the values ", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val item = ShoppingItem(name,amount.toInt())
            addDialogueListener.onAddButtonClicked(item)
            dismiss()
        }
        btnCancel.setOnClickListener {
            cancel()
        }
    }

}