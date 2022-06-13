package ru.gogolev.habbitslist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import ru.gogolev.habbitslist.dto.Habbit

class HabbitCreationActivity : AppCompatActivity() {
    lateinit var newHabbitCreationButton: Button
    lateinit var habbitNameText: EditText
    lateinit var habbitDescriptionText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_habbit_creation)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        habbitNameText = findViewById(R.id.name_field)
        habbitDescriptionText = findViewById(R.id.description_field)

        newHabbitCreationButton = findViewById(R.id.create_btn)
        newHabbitCreationButton.setOnClickListener(View.OnClickListener {
            createNewHabbit()
        })
    }

    private fun createNewHabbit(){
        val habbitName = habbitNameText.text.toString()
        val habbitDescription = habbitDescriptionText.text.toString()
        val intent = Intent()
        intent.putExtra("output", Habbit(habbitName, habbitDescription))
        setResult(RESULT_OK, intent)
        finish()
    }
}