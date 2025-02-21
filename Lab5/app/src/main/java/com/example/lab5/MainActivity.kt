package com.example.lab5

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContentView(R.layout.activity_main)

        val buttonClick : Button = findViewById(R.id.button_one)
        val buttonClickTwo : Button = findViewById(R.id.button_two)
        val buttonClickThree : Button = findViewById(R.id.button_three)

        val editAdress : TextInputLayout = findViewById(R.id.textInputLayout_one)
        val editGift : TextInputLayout = findViewById(R.id.textInputLayout_two)

        buttonClick.setOnClickListener {
            val intent = Intent(this@MainActivity, AboutActivity::class.java)
            startActivity(intent)
        }

        buttonClickTwo.setOnClickListener {
            val intent = Intent(this@MainActivity, SecondActivity::class.java)
            startActivity(intent)
        }
        buttonClickThree.setOnClickListener {
            val intent = Intent(this@MainActivity, SecondActivity::class.java)



            val username = if (editAdress.editText?.text.toString().isNotBlank()) {
                editAdress.editText?.text.toString()
            } else {
                "ЖЫвотное"
            }

            val gift = if (editGift.editText?.text.toString().isNotBlank()) {
                editGift.editText?.text.toString()
            } else {
                "дырку от бублика"
            }

            intent.putExtra("username", username)
            intent.putExtra("gift", gift)
            startActivity(intent)

        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}