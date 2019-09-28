package com.nemesis.course.kitties

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.GridView
import android.widget.Toast
import com.nemesis.course.kitties.adapters.KittiesAdapter
import com.nemesis.course.kitties.model.ConnectionManager
import com.nemesis.course.kitties.model.Kitty

class MainActivity : AppCompatActivity() {

    private lateinit var gridView: GridView
    private lateinit var adapter: KittiesAdapter
    private var kitties = ArrayList<Kitty>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupActivity()
        loadKitties()
    }

    private fun setupActivity(){
        gridView = findViewById(R.id.gridview)

        adapter = KittiesAdapter(this, R.layout.item_kitty, kitties)
        gridView.adapter = adapter

    }

    private fun loadKitties(){
        ConnectionManager.loadKitties(success = { items ->

            kitties.clear()
            kitties.addAll(items)
            adapter.notifyDataSetChanged()

        }, fail = { error ->

            Toast.makeText(this, error, Toast.LENGTH_SHORT).show()

        })
    }
}
