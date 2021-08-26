package com.example.basictasktracker
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.basictasktracker.RecyclerViewAdapter.*

// The adapter class brigdes the layout file and data: tells every piece of data its layout
// 1. Define Adapter class (com.example.basictasktracker > rightclick New > Kotlin/Class File
/* 2. Implement RecyclerView adapter (copy & paste), it needs a ViewHolder which does the findViewByIds
and has a variable which is used to populate data later, its purpose is to make layout more efficient
 */
// 3. Created ViewHolder class
// 4. Created stubs for implement methods (rightclick error > Generate > Implement Methods)
// 5. Must implement each method - ViewHolder,
//6. In the constructor of the adapter class, tell it what items are needed (a list of strings)
//7. RecyclerView needs to know how many items (tasks) are in the list to layout (return x.size), put it in the getItemCount
/* 8. onCreateViewHolder: to inflate the item layout and create the holder. Usually involves inflating a layout from XML and returning the holder
Inflate means to take the XML description of a layout and convert it to Kotlin/Java classes in memory. The process of converting a small amount of XML
text to equivalent but larger Kotlin/Java objects in memory is called inflating */
//9. onBindViewHolder:  Involves populating data into the item through holder, this is where you do something w/ ur findViewByIds which are in variables
// 10. Binding the RecyclerView to the activity: Define the RecyclerView inside MainActivity,

  class RecyclerViewAdapter(private val listOfItems : List<String>)  : RecyclerView.Adapter<ViewHolder>(){
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)  {
    var textView = itemView.findViewById<TextView>(R.id.textView)
        val checkBox = itemView.findViewById<CheckBox>(R.id.checkbox)
        val newTask = itemView.findViewById<EditText>(R.id.new_task)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context                                    // These two lines get the class that will inflate the layout
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val items = inflater.inflate(R.layout.item_layout, parent, false)
        // Return a new holder instance
        return ViewHolder(items)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Get the data model based on position
        val item = listOfItems.get(position)
        // Gets viewHolder and uses reference to set the text of textView to an item

        holder.textView.text = item
        holder.checkBox.setOnClickListener{
            Toast.makeText(holder.itemView.context, "Task #" + (position + 1) + " Complete",Toast.LENGTH_SHORT).show()
        }

}

    override fun getItemCount(): Int {
        return listOfItems.size
    }

  }
