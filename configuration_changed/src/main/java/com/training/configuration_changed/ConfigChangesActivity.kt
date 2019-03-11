package com.training.configuration_changed

import android.content.res.Configuration
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class ConfigChangesActivity : AppCompatActivity() {

    var start = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnIncrease = findViewById<Button>(R.id.btnIncrease)
        val label = findViewById<TextView>(R.id.text)
        btnIncrease.setOnClickListener {
            label.text = start++.toString()
        }
    }

    override fun onConfigurationChanged(newConfig: Configuration?) {
        super.onConfigurationChanged(newConfig)
        Toast.makeText(this, "Orientation ${newConfig?.orientation}", Toast.LENGTH_LONG).show()
    }
}
