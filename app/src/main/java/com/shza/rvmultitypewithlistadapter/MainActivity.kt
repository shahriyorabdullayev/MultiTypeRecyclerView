package com.shza.rvmultitypewithlistadapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rv: RecyclerView
    private lateinit var adapter: CustomAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rv = findViewById(R.id.rv)
        adapter = CustomAdapter()

        rv.adapter = adapter

        adapter.submitList(data())


    }

    fun data(): ArrayList<Portfolio> {
        val list = ArrayList<Portfolio>()
        list.add(Portfolio.Add("add itemman"))
        list.add(Portfolio.Image("Image man"))
        list.add(Portfolio.Image("Image man"))
        list.add(Portfolio.Image("Image man"))
        list.add(Portfolio.Image("Image man"))
        list.add(Portfolio.Image("Image man"))
        list.add(Portfolio.Image("Image man"))


        return list
    }
}