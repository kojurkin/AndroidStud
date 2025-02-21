package com.example.lab3

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContentView(R.layout.activity_main)

        val rootLayout: ConstraintLayout = findViewById(R.id.root_layout)
        val textView: TextView = findViewById(R.id.textView)

        val greenButton: Button = findViewById(R.id.button_green)
        val yellowButton: Button = findViewById(R.id.button_yellow)
        val redButton: Button = findViewById(R.id.button_red)


        val clickListener = View.OnClickListener { view ->
            when (view.id) {
                R.id.button_green -> {
                    textView.text = ("Зелёный")
                    rootLayout.setBackgroundColor(resources.getColor(R.color.greenColor, null))
                }
                R.id.button_yellow -> {
                    textView.text = ("Жёлтый")
                    rootLayout.setBackgroundColor(resources.getColor(R.color.yellowColor, null))
                }
                R.id.button_red -> {
                    textView.text = ("Красный")
                    rootLayout.setBackgroundColor(resources.getColor(R.color.redColor, null))
                }
            }
        }

        greenButton.setOnClickListener(clickListener)
        yellowButton.setOnClickListener(clickListener)
        redButton.setOnClickListener(clickListener)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.root_layout)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

}