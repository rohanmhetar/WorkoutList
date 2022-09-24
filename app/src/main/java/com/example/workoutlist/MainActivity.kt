package com.example.workoutlist

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.workoutlist.adapter.CardAdapter
import com.example.workoutlist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var listIntent: Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Setup view binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.addWorkoutBtn.setOnClickListener { launchAddWorkout() }
        binding.doneBtn.setOnClickListener { launchDone() }
    }
    override fun onResume() {
        super.onResume()
        binding.workoutRecyclerView.adapter = CardAdapter(applicationContext)

        // Specify fixed size to improve performance
        binding.workoutRecyclerView.setHasFixedSize(true)
    }

    /*
     * Launch NewWorkoutActivity
     */
    private fun launchAddWorkout() {
        listIntent = Intent(this, NewWorkoutActivity::class.java)
        startActivity(listIntent)
    }

    /*
     * Launch DoneActivity
     */
    private fun launchDone() {
        listIntent = Intent(this, DoneActivity::class.java)
        startActivity(listIntent)
    }
}