package com.example.basictasktracker

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView.ItemDecoration


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // ...
        // Lookup the recyclerview in activity layout
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        // Initialize list
        var listOfItems = mutableListOf<String>(
            "Study Kotlin",
            "Review Live Instruction Recording",
            "Mentor Meeting"
        )
        val itemDecoration: ItemDecoration =
            DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        recyclerView.addItemDecoration(itemDecoration)
        
        // Create adapter passing in the sample user data
        val adapter = RecyclerViewAdapter(listOfItems)
        // Attach the adapter to the recyclerview to populate items
        recyclerView.adapter = adapter
        // Set layout manager to position the items
        recyclerView.layoutManager = LinearLayoutManager(this)
        // That's all!

        // Gets the string the user types
        findViewById<Button>(R.id.button).setOnClickListener {
            val userInputtedTask = findViewById<EditText>(R.id.new_task).text.toString()
            //The user can add to the list by inputting their own string
            listOfItems.add(userInputtedTask)
            // Update the adapter
            adapter.notifyDataSetChanged()

            fun handleKeyEvent(view: View, keyCode: Int): Boolean {
                if (keyCode == KeyEvent.KEYCODE_ENTER) {
                    // Hide the keyboard
                    val inputMethodManager =
                        getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                    inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
                    return true
                }
                return false

            }

        }
    }
}