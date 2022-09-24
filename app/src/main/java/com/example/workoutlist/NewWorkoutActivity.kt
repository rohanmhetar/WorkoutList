package com.example.workoutlist

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.workoutlist.data.DataSource
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

        val workoutPriorityGroup = findViewById<RadioGroup>(R.id.priority_options)
        val prioritySelected = workoutPriorityGroup.checkedRadioButtonId
        val workoutPriorityInput = findViewById<RadioButton>(prioritySelected)

        val workoutDateVal = "" + workoutDateInput.getMonth() +
                "/" + workoutDateInput.getDayOfMonth() +
                "/" + workoutDateInput.getYear()

        if (workoutNameInput.getText().toString().isBlank() ||
                workoutRepInput.getText().toString().isBlank()) {
            val errorSB = Snackbar.make(findViewById(R.id.newWorkoutCL),
                R.string.empty_fields, Snackbar.LENGTH_LONG)
            errorSB.show()
        } else {
            DataSource.workouts.add(0,
                Workout(
                    workoutNameInput.getText().toString().trim(),
                    workoutDateVal,
                    workoutRepInput.getText().toString().trim().toInt(),
                    workoutPriorityInput.getText().toString().trim().toInt()
                )
            )
            DataSource.workouts.sortBy { it.priority }
            finish()
        }
    }
}