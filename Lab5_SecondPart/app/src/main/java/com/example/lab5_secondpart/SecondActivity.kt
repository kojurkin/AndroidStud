package com.example.lab5_secondpart


import android.content.Intent
import android.os.Bundle
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity

const val THIEF = "ru.alexanderklimov.sherlock.THIEF"

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_second)

        val radioGroup : RadioGroup = findViewById(R.id.radioGroup)

        radioGroup.setOnCheckedChangeListener { _, optionId ->
            val answerIntent = Intent()
            when (optionId) {
                R.id.radio_dog -> answerIntent.putExtra(THIEF, "Сраный пёсик")
                R.id.radio_crow -> answerIntent.putExtra(THIEF, "Ворона")
                R.id.radio_cat -> answerIntent.putExtra(THIEF, "Вася из Москвы")
            }

            setResult(RESULT_OK, answerIntent)
            finish()
        }
    }
}