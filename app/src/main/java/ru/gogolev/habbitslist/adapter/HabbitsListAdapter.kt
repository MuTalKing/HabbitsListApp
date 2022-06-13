package ru.gogolev.habbitslist.adapter

import ru.gogolev.habbitslist.R
import android.annotation.SuppressLint
import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import ru.gogolev.habbitslist.dto.Habbit


class HabbitsListAdapter(private val context: Activity, private val habbits: ArrayList<Habbit>)
    : ArrayAdapter<Habbit>(context, ru.gogolev.habbitslist.R.layout.habbits_list_view, habbits) {

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, view: View?, parent: ViewGroup): View {
        val habbit = habbits.get(position)
        val inflater = context.layoutInflater
        val rowView = inflater.inflate(ru.gogolev.habbitslist.R.layout.habbits_list_view, null, true)

        val titleText = rowView.findViewById(ru.gogolev.habbitslist.R.id.title) as TextView
        val subtitleText = rowView.findViewById(ru.gogolev.habbitslist.R.id.description) as TextView

        titleText.text = habbit.name
        subtitleText.text = habbit.description

        return rowView
    }
}