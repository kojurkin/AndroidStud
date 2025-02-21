package com.example.buttonclick_ravencounter

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private var counter: Int = 0
    private var counterCat: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val textView: TextView = findViewById(R.id.textView)
        val textViewCounterCat: TextView = findViewById(R.id.textView_counter_cat)
        val button: Button = findViewById(R.id.button)
        val buttonCounter: Button = findViewById(R.id.button_counter)
        val buttonCounterCat: Button = findViewById(R.id.button_counter_cat)
        button.setOnClickListener {
            textView.text = "Hello Kitty!"
        }
        buttonCounter.setOnClickListener {
            textView.text = "Я насчитал ${++counter} ворон"
        }
        buttonCounterCat.setOnClickListener {
            textViewCounterCat.text = "Я насчитал ${++counterCat} котов"
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}