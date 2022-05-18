//package com.example.financeapp
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.TextView
//import androidx.recyclerview.widget.DiffUtil
//import androidx.recyclerview.widget.DiffUtil.ItemCallback
//import androidx.recyclerview.widget.ListAdapter
//import androidx.recyclerview.widget.RecyclerView
//import com.example.financeapp.databinding.ActivityMainBinding
//import com.example.financeapp.databinding.RvItemBinding
//
//
//import kotlinx.android.synthetic.main.rv_item.view.*
//
//
////class MainListAdapter : ListAdapter<Trades, MainListAdapter.ViewHolder>(StockDC()) {
////
////    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
////        LayoutInflater.from(parent.context).inflate(R.layout.rv_item, parent, false)
////    )
////
////    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
////        holder.bind(getItem(position))
////
////    fun swapData(data: List<Trades>) = submitList(data.toMutableList())
////
////    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
////
////        fun bind(item: Trades) = with(itemView) {
////
////            text_stock_name.text = item.name
////
////
////            text_current_price.text = "$${item.cost}"
////
////
////        }
////
////
////
////
////
////    }
////
////
////    private class StockDC : DiffUtil.ItemCallback<Trades>() {
////        override fun areItemsTheSame(
////            oldItem: Trades,
////            newItem: Trades
////        ): Boolean = oldItem.name == newItem.name
////
////        override fun areContentsTheSame(
////            oldItem: Trades,
////            newItem: Trades
////        ): Boolean = oldItem == newItem
////    }
////}
//class Adapter(private val data: List<Trades>) : ListAdapter<Trades,Adapter.MyViewHolder>(DiffCallback()){
//
//
// //   private lateinit var binding: RvItemBinding
////    inner class MyViewHolder(val binding : RvItemBinding) : RecyclerView.ViewHolder(binding.root){
////        fun bind(item: Trades) = with(itemView){
////            binding.trades = item
////            text_stock_name.text = item.name
////            text_current_price.text = item.cost.toString()
////
////
////
////
////        }
////    }
//private lateinit var binding: RvItemBinding
//    inner class MyViewHolder(val binding : RvItemBinding) : RecyclerView.ViewHolder(binding.root){
//        fun bind(item: Trades){
//            binding.trades = item
//            binding.textStockName.text = item.name
//            binding.textCurrentPrice.text = item.cost.toString()
//
//
//
//
//
//        }
//    }
////    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
////        val inflater = LayoutInflater.from(parent.context)
////        val listItemBinding = RvItemBinding.inflate(inflater,parent,false)
////        return MyViewHolder(listItemBinding)
////    }
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
//    binding = RvItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//    return MyViewHolder(binding)
//    }
//
//    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
//        holder.bind(data[position])
//    }
//
//    override fun getItemCount(): Int {
//        return data.size
//    }
//    private class DiffCallback  : DiffUtil.ItemCallback<Trades>() {
//        override fun areItemsTheSame(oldItem: Trades, newItem: Trades) =
//            oldItem.name == newItem.name && oldItem.cost !== newItem.cost
//
//        override fun areContentsTheSame(oldItem: Trades, newItem: Trades) =
//            oldItem == newItem
//    }
//
//}
//
//
