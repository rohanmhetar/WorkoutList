package com.example.workoutlist.data

import androidx.recyclerview.widget.SortedList
import com.example.workoutlist.R
import com.example.workoutlist.model.Workout

object DataSource {
    val workouts: MutableList<Workout> = mutableListOf(
        Workout(
            "Squats",
            "9/22/2022",
            20,
            2
        ),
        Workout(
            "Burpees",
            "9/23/2022",
            50,
            3
        )
    )
    val done: MutableList<Workout> = mutableListOf(
        Workout(
            "Bench Press",
            "9/21/2022",
            20,
            0
        )
    )
}