package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.GridLayoutManager
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

        val adapter=ItemAdapter(this,items)
        mainBinding.rv.adapter=adapter
        newRecyclerView=mainBinding.rv
        newRecyclerView.layoutManager=LinearLayoutManager(this)
        mainBinding.rv.layoutManager=GridLayoutManager(this,2)
    }
}