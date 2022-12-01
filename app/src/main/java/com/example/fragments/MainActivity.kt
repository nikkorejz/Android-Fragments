package com.example.fragments

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity(), ModelListFragment.MyInteractionListener {

    private var fragmentContainer: View? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fragmentContainer = findViewById(R.id.FragmentContainer)
    }

    override fun onModelChosen(id: Long) {
        fragmentContainer?.let {
            // If container is not null
            val fragment = DetailFragment()
            fragment.setModelId(id)
            with(supportFragmentManager.beginTransaction()) {
                replace(R.id.FragmentContainer, fragment)
                addToBackStack(null)
                setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                commit()
            }
        } ?: run {
            // If container is null
            with(Intent(this, DetailActivity::class.java)) {
                putExtra(DetailActivity.EXTRA_MODEL_ID, id)
                startActivity(this)
            }
        }
    }
}