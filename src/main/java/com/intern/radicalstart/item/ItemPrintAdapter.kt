package com.intern.radicalstart.item

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.intern.radicalstart.R

class ItemPrintAdapter(var mContext:Context,var items:ArrayList<Int>, var itemClickListener:ItemClickInterfaces):RecyclerView.Adapter<ItemPrintAdapter.ViewHolder>(){
    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val itemName=itemView.findViewById(R.id.tv_item)as TextView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.adapter_item_print,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.itemName.text= "Item $item"
        holder.itemName.setOnClickListener {
            itemClickListener.itemClick(item)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
    interface ItemClickInterfaces{
        fun itemClick(id:Int)
    }

}