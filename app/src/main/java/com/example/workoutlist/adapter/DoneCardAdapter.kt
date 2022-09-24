package com.example.workoutlist.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.workoutlist.R
import com.example.workoutlist.data.DataSource
import com.example.workoutlist.model.Workout
import com.google.android.material.floatingactionbutton.FloatingActionButton

class DoneCardAdapter(
    private val context: Context?
): RecyclerView.Adapter<DoneCardAdapter.CardViewHolder>() {

    // import data from DataSource.kt
    private val data: MutableList<Workout> = DataSource.done

    /**
     * Initialize view elements
     */
    class CardViewHolder(view: View?): RecyclerView.ViewHolder(view!!) {
        val workoutName: TextView = view!!.findViewById(R.id.workoutName)
        val workoutDate: TextView = view!!.findViewById(R.id.workoutDate)
        val numReps: TextView = view!!.findViewById(R.id.numReps)
        val deleteBtn: FloatingActionButton = view!!.findViewById(R.id.deleteButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        // determine the layout type and set it accordingly using a conditional
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.done_layout, parent, false)

        return CardViewHolder(adapterLayout)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: DoneCardAdapter.CardViewHolder, position: Int) {
        val resources = context?.resources

        // set corresponding resources from data list
        val item = data[position]
        holder.workoutName.text = item.name
        holder.workoutDate.text = item.date
        holder.numReps.text = item.reps.toString() + " reps"

        // enable functionality for delete button
        holder.deleteBtn.setOnClickListener {
            DataSource.done.remove(item)
            this.notifyDataSetChanged() }
    }
}