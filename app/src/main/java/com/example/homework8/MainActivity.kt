package com.example.homework8

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homework8.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter : RecyclerViewAdapter
    private val items = mutableListOf<Model>()
    private lateinit var new :Intent


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init(){
        addata()
         adapter = RecyclerViewAdapter(items,object : ItemListener{
             override fun itemOnClick(position: Int) {
                Intent(this@MainActivity,SecondActivity::class.java).also{
                     startActivity(it)
                 }
             }

             override fun itemOnLongClick(position: Int) {
                items.removeAt(position)
                 adapter.notifyItemRemoved(position)
             }

         })
        binding.recyclerView.layoutManager = GridLayoutManager(this,2)
        binding.recyclerView.adapter = adapter
    }

    private fun addata(){
        items.add(Model(R.drawable.ic_beetle,"Beetle","mweri","qartulad xocho"))
        items.add(Model(R.drawable.ic_boar,"Boar","cxoveli","qartulad taxi"))
        items.add(Model(img=null,"Lion","cxoveli","qartilad lomi"))
        items.add(Model(R.drawable.ic_girrafe,"Girrafe","cxoveli","qartulad jirafi"))
        items.add(Model(img=null,"mouse","mgrgneli","qartulad tagvi"))
        items.add(Model(img=null,"Snake","qvewarmavali","qartulad gveli"))
        items.add(Model(R.drawable.ic_panda,"panda","cxoveli","qartulad panda"))
        items.add(Model(img=null,"Dog","cxoveli","qartulad dzagi"))
        items.add(Model(img=null,"Chicken","frinveli","qartulad qatami"))
        items.add(Model(R.drawable.ic_parrot,"Parrot","frinveli","qartulad tutiyushi"))
        items.add(Model(img=null,"Wolf","cxoveli","qartulad mgeli"))
        items.add(Model(R.drawable.ic_rhino,"Rhino","cxoveli","qartulad martorqa"))
    }
}