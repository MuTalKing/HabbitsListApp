package ru.gogolev.habbitslist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import ru.gogolev.habbitslist.dto.Habbit

class HabbitDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_habbit_detail)

        val nameField: TextView = findViewById(R.id.name_details_field)
        val descriptionField: TextView = findViewById(R.id.description_details_field)

        val habbit = intent.getParcelableExtra<Habbit>("output")
        nameField.text = habbit!!.name
        descriptionField.text = habbit.description
    }
}