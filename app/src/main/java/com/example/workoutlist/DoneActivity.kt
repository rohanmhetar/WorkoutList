package com.example.workoutlist

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.workoutlist.adapter.CardAdapter
import com.example.workoutlist.adapter.DoneCardAdapter
import com.example.workoutlist.data.DataSource
import com.example.workoutlist.databinding.ActivityDoneBinding
import com.example.workoutlist.databinding.ActivityMainBinding

class DoneActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDoneBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Setup view binding
        binding = ActivityDoneBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Enable up button for backward navigation
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.deleteAllBtn.setOnClickListener { deleteAll() }
    }
    override fun onResume() {
        super.onResume()
        binding.doneRecyclerView.adapter = DoneCardAdapter(applicationContext)

        // Specify fixed size to improve performance
        binding.doneRecyclerView.setHasFixedSize(true)
    }

    private fun deleteAll() {
        DataSource.done.clear()
        binding.doneRecyclerView.adapter?.notifyDataSetChanged()
    }
}