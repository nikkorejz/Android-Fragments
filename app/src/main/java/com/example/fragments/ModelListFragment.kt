package com.example.fragments

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.ListFragment

class ModelListFragment : ListFragment() {

    interface MyInteractionListener {
        fun onModelChosen(id: Long)
    }

    private lateinit var listener: MyInteractionListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val names = Array(MyModel.models.size) { "" }
        for (i in 0 until MyModel.models.size) {
            names[i] = MyModel.models[i].name
        }

        val adapter =
            activity?.let { ArrayAdapter(it, android.R.layout.simple_list_item_1, names) }
        listAdapter = adapter
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as MyInteractionListener
    }

    override fun onListItemClick(l: ListView, v: View, position: Int, id: Long) {
        super.onListItemClick(l, v, position, id)

        listener.onModelChosen(id)
    }
}