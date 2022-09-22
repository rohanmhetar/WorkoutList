package com.example.workoutlist

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.workoutlist.adapter.CardAdapter
import com.example.workoutlist.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var listIntent: Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Setup view binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.workoutRecyclerView.adapter = CardAdapter(applicationContext)

        // Specify fixed size to improve performance
        binding.workoutRecyclerView.setHasFixedSize(true)

        binding.addWorkoutBtn.setOnClickListener { launchAddWorkout() }
    }

    private fun launchAddWorkout() {
        listIntent = Intent(this, NewWorkoutActivity::class.java)
        startActivity(listIntent)
    }
}