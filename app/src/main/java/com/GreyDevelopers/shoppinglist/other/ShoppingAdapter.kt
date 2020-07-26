package com.GreyDevelopers.shoppinglist.other

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.GreyDevelopers.shoppinglist.R
import com.GreyDevelopers.shoppinglist.data.db.entities.ShoppingItem
import com.GreyDevelopers.shoppinglist.ui.shoppinglist.ShoppingViewModel
import kotlinx.android.synthetic.main.shopping_item.view.*

class ShoppingAdapter(
    var items: List<ShoppingItem>,
    private val viewModel: ShoppingViewModel
) : RecyclerView.Adapter<ShoppingAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val ivPlus = itemView.findViewById<ImageView>(R.id.ivPlus)
        val ivMinus = itemView.findViewById<ImageView>(R.id.ivMinus)
        val ivDelete = itemView.findViewById<ImageView>(R.id.ivDelete)

        init {
            itemView.ivDelete.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    viewModel.delete(items[position])
                }
            }
            itemView.ivPlus.setOnClickListener {
                val position = adapterPosition
                items[position].amount++
                val am = items[position]
                if (position != RecyclerView.NO_POSITION) {
                    viewModel.updateOrInsert(am)
                }
            }
            itemView.ivMinus.setOnClickListener {
                val position = adapterPosition
                if (items[position].amount > 0) {
                    items[position].amount--
                    val am = items[position]
                    if (position != RecyclerView.NO_POSITION) {
                        viewModel.updateOrInsert(am)
                    }
                }
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.shopping_item, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val curentShoppingItem = items[position]
        holder.itemView.tvName.text = curentShoppingItem.name
        holder.itemView.tvAmount.text = "${curentShoppingItem.amount}"
    }


}