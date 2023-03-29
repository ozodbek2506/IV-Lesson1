package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var newRecyclerView: RecyclerView
    lateinit var mainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding=ActivityMainBinding.inflate(layoutInflater)

        setContentView(mainBinding.root)
        var items = mutableListOf<ItemData>()


        val adapter=ItemAdapter(this,items)
        mainBinding.rv.adapter=adapter
        newRecyclerView=mainBinding.rv
        newRecyclerView.layoutManager=LinearLayoutManager(this)
        mainBinding.rv.layoutManager=GridLayoutManager(this,2)

        val touchHelper = object : ItemTouchHelper.Callback(){
            override fun getMovementFlags(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder
            ): Int {
                val dragFlags = ItemTouchHelper.UP or ItemTouchHelper.DOWN
                val swipeFlags = ItemTouchHelper.START or ItemTouchHelper.END
                return makeMovementFlags(dragFlags,swipeFlags)
            }

            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                adapter.onItemMove(viewHolder.adapterPosition, target.adapterPosition)
                return true
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                adapter.onItemDismiss(viewHolder.adapterPosition)
            }

        }

        val itemTouchHelper = ItemTouchHelper(touchHelper)
        itemTouchHelper.attachToRecyclerView(mainBinding.rv)
        mainBinding.rv.adapter = adapter


        var count=0
        for (i in 1..25){
            if (count%4==0){
                count=0
            }
            if (count==0){
                items.add(ItemData(R.drawable.bg,"Name 1","Reciept 1"))
            }
            if (count==1){
                items.add(ItemData(R.drawable.bg2,"Name 2","Reciept 2"))
            }
            if (count==2){
                items.add(ItemData(R.drawable.bg3,"Name 3","Reciept 3"))
            }
            if (count==3){
                items.add(ItemData(R.drawable.bg4,"Name 4","Reciept 4"))
            }
               count++
        }


    }
}