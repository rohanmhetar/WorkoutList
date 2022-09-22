package com.example.workoutlist.data

import com.example.workoutlist.R
import com.example.workoutlist.model.Workout

object DataSource {
    val workouts: List<Workout> = listOf(
        Workout(
            "Push-Ups",
            "9/22/22",
            50
        ),
        Workout(
            "Squats",
            "9/22/22",
            20
        ),
        Workout(
            "Bench Press",
            "9/23/22",
            10
        ),
        Workout(
            "Burpees",
            "9/23/22",
            50
        ),
        Workout(
            "Medicine Ball Lunges",
            "9/23/22",
            20
        )
    )
}