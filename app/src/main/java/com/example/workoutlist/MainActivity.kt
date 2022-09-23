package com.example.workoutlist

import android.content.Intent
import android.os.Bundle
import android.widget.DatePicker
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.workoutlist.adapter.CardAdapter
import com.example.workoutlist.data.DataSource
import com.example.workoutlist.databinding.ActivityMainBinding
import com.example.workoutlist.model.Workout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.tabs.TabLayoutMediator

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

    private fun launchAddWorkout() {
        listIntent = Intent(this, NewWorkoutActivity::class.java)
        startActivity(listIntent)
    }

    private fun launchDone() {
        listIntent = Intent(this, DoneActivity::class.java)
        startActivity(listIntent)
    }
}