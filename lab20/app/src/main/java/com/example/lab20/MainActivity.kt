package com.example.lab20

import android.os.Bundle
import android.view.KeyEvent
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {

    var back_pressed: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
                    rootLayout.setBackgroundColor(resources.getColor(R.color.yellow, null))
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
    }

    //метод отвечает за появление меню у активности
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val textV : TextView = findViewById(R.id.textView2)

        when (item.itemId) {
            R.id.action_cat1 -> {
                textV.text = "Вы выбрали кота!"
                return true
            }
            R.id.action_cat2 -> {
                textV.text = "Вы выбрали кошку!"
                return true
            }
            R.id.action_cat3 -> {
                textV.text = "Вы выбрали котёнка!"
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        AlertDialog.Builder(this).apply {
            setTitle("Подтверждение")
            setMessage("Вы уверены, что хотите выйти из программы?")

            setPositiveButton("Таки да") { _, _ ->
                super.onBackPressed()
            }

            setNegativeButton("Нет"){_, _ ->
                // if user press no, then return the activity
                Toast.makeText(this@MainActivity, "Thank you",
                    Toast.LENGTH_LONG).show()
            }
            setCancelable(true)
        }.create().show()
    }

//    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
//        val rootLayout: ConstraintLayout = findViewById(R.id.root_layout)
//        when (keyCode) {
//            KeyEvent.KEYCODE_1 -> {
//                // Устанавливаем фон в зеленый цвет при нажатии кнопки увеличения громкости
//                rootLayout.setBackgroundColor(resources.getColor(R.color.greenColor, null))
//                return true
//            }
//            KeyEvent.KEYCODE_2 -> {
//                // Устанавливаем фон в красный цвет при нажатии кнопки уменьшения громкости
//                rootLayout.setBackgroundColor(resources.getColor(R.color.greensColor, null))
//                return true
//            }
//        }
//        return super.onKeyDown(keyCode, event)
//    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        when (keyCode) {
            KeyEvent.KEYCODE_MENU -> {
                Toast.makeText(this, "Нажата кнопка Меню", Toast.LENGTH_SHORT)
                    .show()
                return true
            }

            KeyEvent.KEYCODE_SEARCH -> {
                Toast.makeText(this, "Нажата кнопка Поиск", Toast.LENGTH_SHORT)
                    .show()
                return true
            }

            KeyEvent.KEYCODE_BACK -> {
                onBackPressed()
                return true
            }

            KeyEvent.KEYCODE_VOLUME_UP -> {
                event.startTracking()
                return true
            }

            KeyEvent.KEYCODE_VOLUME_DOWN -> {
                Toast.makeText(this, "Нажата кнопка громкости", Toast.LENGTH_SHORT)
                    .show()
                return false
            }
        }
        return super.onKeyDown(keyCode, event)
    }

    override fun onKeyUp(keyCode: Int, event: KeyEvent?): Boolean {
        val rootLayout: ConstraintLayout = findViewById(R.id.root_layout)
        when (keyCode) {
            KeyEvent.KEYCODE_3 -> {
                // Устанавливаем фон в желтый цвет при отпускании кнопки увеличения громкости
                rootLayout.setBackgroundColor(resources.getColor(R.color.ex, null))
                return true
            }
            KeyEvent.KEYCODE_4 -> {
                // Устанавливаем фон в синий цвет при отпускании кнопки уменьшения громкости
                rootLayout.setBackgroundColor(resources.getColor(R.color.purple, null))
                return true
            }
        }
        return super.onKeyUp(keyCode, event)
    }

    override fun onUserLeaveHint() {
        val toast = Toast.makeText(applicationContext, "Нажата кнопка HOME", Toast.LENGTH_SHORT)
        toast.show()
        super.onUserLeaveHint()
    }


}