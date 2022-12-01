package com.example.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class DetailActivity : AppCompatActivity() {

    companion object {
        val EXTRA_MODEL_ID = "ModelIdParam"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val fragment: DetailFragment = supportFragmentManager.findFragmentById(R.id.FragmentDetail) as DetailFragment

        val modelId = intent?.extras?.getLong(EXTRA_MODEL_ID)
        modelId?.let { fragment.setModelId(it) }
    }
}