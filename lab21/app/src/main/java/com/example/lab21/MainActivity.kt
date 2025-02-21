package com.example.lab21

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val flagCountry : ImageView = findViewById(R.id.imageView)

    }
    //метод отвечает за появление меню у активности
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val textV : TextView = findViewById(R.id.textView)

        when (item.itemId) {
            R.id.action_cat1 -> {
                textV.text = getResources().getString(R.string.action_cat_male)
                return true
            }
            R.id.action_cat2 -> {
                textV.text = getResources().getString(R.string.action_cat_female)
                return true
            }
            R.id.action_cat3 -> {
                textV.text = getResources().getString(R.string.action_kitten)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}