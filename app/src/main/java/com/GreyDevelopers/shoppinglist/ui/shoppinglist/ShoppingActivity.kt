package com.GreyDevelopers.shoppinglist.ui.shoppinglist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.GreyDevelopers.shoppinglist.R
import com.GreyDevelopers.shoppinglist.data.db.ShoppingDatabase
import com.GreyDevelopers.shoppinglist.data.db.entities.ShoppingItem
import com.GreyDevelopers.shoppinglist.data.repositories.ShoppingRepository
import com.GreyDevelopers.shoppinglist.other.ShoppingAdapter
import kotlinx.android.synthetic.main.activity_shopping.*
import org.kodein.di.android.kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.instance

class ShoppingActivity : AppCompatActivity(),KodeinAware {
    override  val  kodein by kodein()
    private val factory: ShoppingViewModelFactory by instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping)
        supportActionBar?.title = "Shopping List"
        
        val viewModel = ViewModelProviders.of(this,factory).get(ShoppingViewModel::class.java)

        val adapter = ShoppingAdapter(listOf(),viewModel)
        rcv.layoutManager = LinearLayoutManager(this)
        rcv.adapter = adapter

        viewModel.getAllItems().observe(this, Observer {
            adapter.items = it
            adapter.notifyDataSetChanged()
        })

        fab.setOnClickListener{
            AddShoppingDialogue(this,
            object : AddDialogueListener{
                override fun onAddButtonClicked(item: ShoppingItem) {
                    viewModel.updateOrInsert(item)
                }
            }).show()
        }

    }
}