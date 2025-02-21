package com.example.lab7

import android.app.AlertDialog
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputLayout


class MainActivity : AppCompatActivity() {

    //lab8 константы для продолжительности всплывающего сообщения
    val LONG_DELAY: Int = 3500 // 3.5 seconds
    val SHORT_DELAY: Int = 2000 // 2 seconds
    //lab8

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContentView(R.layout.activity_main)

        //lab8
        val buttonShowToast : Button = findViewById(R.id.button_five)
        val imageToast : ImageView = findViewById(R.id.imageView)
        imageToast.setImageResource(R.drawable.cat_thief)
        //lab8

        val buttonClick : Button = findViewById(R.id.button_one)
        val buttonClickTwo : Button = findViewById(R.id.button_two)
        val buttonClickThree : Button = findViewById(R.id.button_three)
        val editAdress : TextInputLayout = findViewById(R.id.textInputLayout_one)
        val editGift : TextInputLayout = findViewById(R.id.textInputLayout_two)

        buttonClick.setOnClickListener {
            val intent = Intent(this@MainActivity, AboutActivity::class.java)

            val builder = AlertDialog.Builder(this, R.style.AppCompatAlertDialogStyle)
            builder.setTitle("Dialog")
            builder.setMessage("Покормить кота?")
            builder.setPositiveButton("Старт") { _, _ ->   // Запуск при нажатии на Старт
                startActivity(intent)
            }
            builder.setNegativeButton("Cancel", null)
            builder.show()
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

        //lab8
        buttonShowToast.setOnClickListener {
            val text = "Пора покормить кота!"
            val duration = Toast.LENGTH_SHORT
            val toast = Toast.makeText(applicationContext, text, duration)
            toast.setGravity(Gravity.CENTER, 0, 0)
            toast.show()
        }

        imageToast.setOnClickListener {
            val toast = Toast.makeText(applicationContext, R.string.cat_food, Toast.LENGTH_LONG)
            toast.setGravity(Gravity.HORIZONTAL_GRAVITY_MASK, 0, 0)
            val toastContainer = toast.show() as LinearLayout
            val catImage = ImageView(this)
            catImage.setImageResource(R.drawable.meat)
            toastContainer.addView(catImage, 0)
            toast.show()
        }
        //lab8

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}