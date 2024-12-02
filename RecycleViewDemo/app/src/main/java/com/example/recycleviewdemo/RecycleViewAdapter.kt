package com.example.recycleviewdemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// Adapter class for managing and displaying a list of messages in a RecyclerView
class RecycleViewAdapter: RecyclerView.Adapter<RecycleViewAdapter.RecycleViewHolder>() {

    // List to hold the data (a collection of Message objects) that the RecyclerView will display
    var messages: ArrayList<Message> = ArrayList()

    // ViewHolder class: Represents a single item (row) in the RecyclerView
    inner class RecycleViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        // UI components in the layout for each item
        val name = view.findViewById<TextView>(R.id.tv_name)
        val text = view.findViewById<TextView>(R.id.tv_text)
        val img = view.findViewById<ImageView>(R.id.iv_view)
    }

    // Called to create the ViewHolder object (the structure of each item)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecycleViewHolder {
        // Inflate the XML layout file for a single item (row in the RecyclerView)
        val view  = LayoutInflater.from(parent.context).inflate(R.layout.recycle_view,parent, false)
        return RecycleViewHolder(view)
    }

    // Returns the total number of items in the data list
    override fun getItemCount(): Int {
        return messages.size
    }

    // Called to bind data to the UI components of a specific item
    override fun onBindViewHolder(holder: RecycleViewHolder, position: Int) {
        // Bind the data from the 'messages' list to the UI components
        holder.name.text = messages[position].name
        holder.text.text = messages[position].text
        holder.img.setImageResource(messages[position].image)
    }

    // Function to add a new item (Message object) to the list
    fun getItem (message: Message) {
        messages.add(message)
        // Notify the RecyclerView that the data has changed (refresh the UI)
        notifyDataSetChanged()
    }

}