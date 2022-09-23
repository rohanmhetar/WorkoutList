package com.example.workoutlist

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NavUtils
import com.example.workoutlist.data.DataSource
import com.example.workoutlist.databinding.ActivityMainBinding
import com.example.workoutlist.databinding.NewWorkoutBinding
import com.example.workoutlist.model.Workout
import com.google.android.material.snackbar.Snackbar

class NewWorkoutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.new_workout)

        // Enable up button for backward navigation
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        findViewById<Button>(R.id.submitBtn).setOnClickListener { addWorkout() }
    }

    private fun addWorkout() {
        val workoutNameInput = findViewById<EditText>(R.id.workoutNameInput)
        val workoutDateInput = findViewById<DatePicker>(R.id.workoutDatePicker)
        val workoutRepInput = findViewById<EditText>(R.id.workoutRepInput)

        val workoutDateVal = "" + workoutDateInput.getMonth() +
                "/" + workoutDateInput.getDayOfMonth() +
                "/" + workoutDateInput.getYear()

        if (workoutNameInput.getText().toString().isBlank() ||
                workoutRepInput.getText().toString().isBlank()) {
            val errorSB = Snackbar.make(findViewById(R.id.newWorkoutCL),
                R.string.empty_fields, Snackbar.LENGTH_LONG)
            errorSB.show()
        } else {
            DataSource.workouts.add(
                Workout(
                    workoutNameInput.getText().toString().trim(),
                    workoutDateVal,
                    workoutRepInput.getText().toString().trim().toInt()
                )
            )
            finish()
        }
    }
}