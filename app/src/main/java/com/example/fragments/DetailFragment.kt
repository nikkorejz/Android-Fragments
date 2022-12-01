package com.example.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class DetailFragment : Fragment() {

    private var modelId: Long = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.detail_fragment, container, false)
    }

    override fun onStart() {
        super.onStart()
        view?.let {
            val titleTextView = it.findViewById<TextView>(R.id.TextViewTitle)
            val descriptionTextView = it.findViewById<TextView>(R.id.TextViewDescription)

            val myModel = MyModel.models[modelId.toInt()]
            titleTextView.text = myModel.name
            descriptionTextView.text = myModel.description
        }
    }

    fun setModelId(id: Long) {
        modelId = id
    }
}