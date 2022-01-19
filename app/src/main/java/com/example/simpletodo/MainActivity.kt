package com.example.simpletodo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.FileUtils
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.io.File
import java.io.IOException
import java.nio.charset.Charset

class MainActivity : AppCompatActivity() {
    var listOfTasks = mutableListOf<String>()

    lateinit var adapter: TaskItemAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val onLongClickListener = object : TaskItemAdapter.OnLongClickListener {
            override fun onItemLongClicked(position: Int) {
                //1. Remove Item from the list
                listOfTasks.removeAt(position)

                // 2. Notify the adapter something has changed
                adapter.notifyDataSetChanged()

                saveData()


            }

        }



//        //Detecting when the user clicks on the add button
//        findViewById<Button>(R.id.addButton).setOnClickListener {
//            //Once clicked, the code here will be executed
//            Log.i("Ugonna","User clicked on the button")


        loadData()

        //Look up recyclerview in the layout
        val recyclerView =findViewById<RecyclerView>(R.id.recyclerView)
        // Create adapter passing in the sample user data
        adapter = TaskItemAdapter(listOfTasks, onLongClickListener)
        // Attach the adapter to the recyclerview to populate items
        recyclerView.adapter = adapter
        // Set layout manager to position the items
        recyclerView.layoutManager = LinearLayoutManager(this)

        val inputTextField = findViewById<EditText>(R.id.Add_task)

        //Get reference to the button
        //then set on click listener
        findViewById<Button>(R.id.addButton).setOnClickListener {
            //1.Grab the task the user has inputted into the text  @+id/Add_task"
            val userInputtedTask = inputTextField.text.toString()

            //2.Add the string to our list of tasks
            listOfTasks.add(userInputtedTask)

            //Notify the adapter about updated data
            adapter.notifyItemInserted(listOfTasks.size -1)

            //3. Reset Text field
            inputTextField.setText("")

            saveData()
        }

        }
    //Save the data by reading and writing from a specific file that the user has inputted

    //Create a method to get the data file we need
    fun getDataFile(): File {
        //every line represents a specific task
        return File(filesDir, "stuff.txt")
    }


    //Load the items by reading every line in the data file
    fun loadData(){
        try {
            listOfTasks =
                org.apache.commons.io.FileUtils.readLines(getDataFile(), Charset.defaultCharset())
        }catch (ioException: IOException) {
            ioException.printStackTrace()
        }
    }

    //Save the items by writing them into our data file
    fun saveData() {
        try {
                org.apache.commons.io.FileUtils.writeLines(getDataFile(),listOfTasks)

        }catch (ioException: IOException){
            ioException.printStackTrace()

        }        }



}