package com.example.simpletodo

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

//This is a bridge that tells the recyclerview how to display data given
class TaskItemAdapter(val listOfTasks: List<String>,
                      val longClickListener: OnLongClickListener):
    RecyclerView.Adapter<TaskItemAdapter.ViewHolder>() {

    interface OnLongClickListener {
        fun onItemLongClicked(position: Int)
    }

    //Tells the recyclerview how to layout each item
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val contactView = inflater.inflate(android.R.layout.simple_list_item_1, parent, false)
        // Return a new holder instance
        return ViewHolder(contactView)
    }
    //takes whatever is in list of items to populate viewholder
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Get the data model based on position

        //Get data model based on position
        val item= listOfTasks.get(position)

        holder.textView.text = item
    }

    override fun getItemCount(): Int {
        //size of our list of items
        return listOfTasks.size

    }

    //This provides a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for quick access
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //Stores references to elements in our layout view
        val textView: TextView

        init{
            textView = itemView.findViewById(android.R.id.text1)
            itemView.setOnLongClickListener {
                //Log.i("Ugonna" , "long clicked on item: " + adapterPosition)
                longClickListener.onItemLongClicked(adapterPosition)
                true
            }

        }


    }

}