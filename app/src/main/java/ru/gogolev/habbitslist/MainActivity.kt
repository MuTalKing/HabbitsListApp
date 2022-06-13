package ru.gogolev.habbitslist

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.widget.Button
import android.widget.ListView
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.appcompat.app.AppCompatActivity
import ru.gogolev.habbitslist.adapter.HabbitsListAdapter
import ru.gogolev.habbitslist.contracts.HabbitCreationActivityContract
import ru.gogolev.habbitslist.dto.Habbit


class MainActivity : AppCompatActivity() {
    lateinit var createNewHabbitButton: Button
    lateinit var listView: ListView
    lateinit var adapter: HabbitsListAdapter
    lateinit var mLatestHabbit: Habbit
    val listHabbits = arrayListOf<Habbit>()

    private val mGetHabbit: ActivityResultLauncher<Unit> =
        registerForActivityResult(
            HabbitCreationActivityContract(),  // Callback to be called when event is received
            ActivityResultCallback<Habbit> { result -> // Save as latest event received
                mLatestHabbit = result
                listHabbits.add(mLatestHabbit)
                adapter.notifyDataSetChanged()
            }
        )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listView = findViewById(R.id.listView)
        adapter = HabbitsListAdapter(this, listHabbits)
        listView.adapter = adapter
        listView.choiceMode = ListView.CHOICE_MODE_MULTIPLE


        createNewHabbitButton = findViewById<Button>(R.id.create_btn)
        createNewHabbitButton.setOnClickListener(View.OnClickListener {
            openHabbitCreationActivity()
        })

        listView.setOnItemClickListener { parent, view, position, id ->
            val element = adapter.getItem(position) // The item that was clicked
            val intent = Intent(this, HabbitDetailActivity::class.java)
            intent.putExtra("output", Habbit(element!!.name, element!!.description))
            startActivity(intent)
        }




    }

    private fun openHabbitCreationActivity() {
        mGetHabbit.launch(null)
    }
}
