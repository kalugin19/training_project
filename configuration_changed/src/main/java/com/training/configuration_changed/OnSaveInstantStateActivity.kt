package com.training.configuration_changed

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import kotlin.random.Random

class OnSaveInstantStateActivity : AppCompatActivity() {

    var number: Int? = null

    companion object {
        const val COUNTER_KEY = "counter_key"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_save_instance)
        val label = findViewById<TextView>(R.id.text)
        number = if (savedInstanceState == null || !savedInstanceState.containsKey(COUNTER_KEY)) {
            loadRandomNumber()
        } else {
            savedInstanceState.getInt(COUNTER_KEY)
        }
        label.text = number.toString()
    }

    private fun loadRandomNumber(): Int {
        Thread.sleep(3000)
        return Random(100).nextInt()

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        if (number != null) {
            outState.putInt(COUNTER_KEY, number!!)
        }
    }

}