package com.example.financeapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import java.util.*

//
class MyAdapter : ListAdapter<Trades, MyAdapter.MyViewHolder>(DiffCallback()) {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val stockname: TextView = itemView.findViewById(R.id.text_stock_name)
        val currentprice: TextView = itemView.findViewById(R.id.text_current_price)

        fun bind(item: Trades) = with(itemView) {
            stockname.text = item.name
            currentprice.text = item.cost.toString()


        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.rv_item, parent, false)
        )
    }
    fun swapData(data: List<Trades>) = submitList(data.toMutableList())
    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}
private class DiffCallback : DiffUtil.ItemCallback<Trades>() {
    override fun areItemsTheSame(
        oldItem: Trades,
        newItem: Trades
    ): Boolean = oldItem.name == newItem.name && oldItem.id != newItem.id

    override fun areContentsTheSame(
        oldItem: Trades,
        newItem: Trades
    ): Boolean = oldItem == newItem
}


