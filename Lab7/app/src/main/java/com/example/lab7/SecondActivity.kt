package com.example.lab7

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val textviewSecondInfo : TextView = findViewById(R.id.textView_one)
        val user = intent.getStringExtra("username")?: "ЖЫвотное"
        val gift = intent.getStringExtra("gift")?: "дырку от бублика"
        textviewSecondInfo.text = user +  ", вам передали: " + gift

    }
}