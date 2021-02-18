package com.intern.radicalstart.item

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.intern.radicalstart.R
import kotlinx.android.synthetic.main.activity_item_print.*

class ItemPrintActivity : AppCompatActivity() {
    var items=ArrayList<Int>()
    private val itemViewModel:ItemPrintViewModel by lazy{ ViewModelProvider(this).get(ItemPrintViewModel::class.java) }
    private val itemAdapter by lazy { ItemPrintAdapter(this,items,object :ItemPrintAdapter.ItemClickInterfaces{
        override fun itemClick(id: Int) {
            val newUser=ArrayList<Int>()
            for(i in id until items.size){
                newUser.add(i)
            }
            for(i in 0 until id){
                newUser.add(i)
            }
            items.clear()
            items.addAll(newUser)
            rv_item?.adapter?.notifyDataSetChanged()
        }
    }) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_print)
        rv_item.layoutManager=LinearLayoutManager(this,RecyclerView.VERTICAL,false)
        rv_item.adapter=itemAdapter
        for(i in  0..10){
            items.add(i)
        }
        rv_item?.adapter?.notifyDataSetChanged()
    }
}