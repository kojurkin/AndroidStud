package com.example.lab13

import android.graphics.Point
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.util.DisplayMetrics
import android.util.Log
import android.view.Display
import android.widget.Button
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContentView(R.layout.activity_main)

        val button: Button = findViewById(R.id.button)


        //яркость экрана в приложении
        val backLightSeekBar = findViewById<SeekBar>(R.id.seekBar)
        val settingTextView = findViewById<TextView>(R.id.textViewSetting)

        backLightSeekBar
            .setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
                override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                    var backLightValue = progress.toFloat() / 100
                    if (backLightValue < 0.1) {
                        backLightValue = 0.1.toFloat()
                    }
                    settingTextView.text = backLightValue.toString()

                    val layoutParams = window
                        .attributes
                    layoutParams.screenBrightness = backLightValue
                    window.attributes = layoutParams
                }

                override fun onStartTrackingTouch(seekBar: SeekBar) {
                }

                override fun onStopTrackingTouch(seekBar: SeekBar) {
                }
            })





        //информация яркости экрана в логах
        try {
            val curBrightnessValue = Settings.System.getInt(
                contentResolver,
                Settings.System.SCREEN_BRIGHTNESS
            )
            Log.i("Screen", "Текущая яркость экрана: $curBrightnessValue")
        } catch (e: Settings.SettingNotFoundException) {
            e.printStackTrace()
        }


        //показать окно Экран из системного приложения Настройки
//        val intent = Intent(Settings.ACTION_DISPLAY_SETTINGS)
//        if (intent.resolveActivity(packageManager) != null) {
//            startActivity(intent)
//        }

        //в логах размер экрана
        //Ориентацию при помощи нового метода не узнаешь
        val display: Display = windowManager.defaultDisplay
        val point = Point()
        display.getSize(point)
        val screenWidth: Int = point.x
        val screenHeight: Int = point.y
        // Теперь получим необходимую информацию
        val width = Integer.toString(screenWidth)
        val height = Integer.toString(screenHeight)
        val info = "Ширина: $width; Высота: $height"
        Log.i("Screen", info)


        //узнать настройки экрана через кнопку
        button.setOnClickListener {
            var screen = ""
            val metrics = DisplayMetrics()

            if (Build.VERSION.SDK_INT >= 30){
                display?.apply {
                    getRealMetrics(metrics)
                    screen = """
                Width: ${metrics.widthPixels} pixels
                Height: ${metrics.heightPixels} pixels 
                The Logical Density: ${metrics.density}  
                X Dimension: ${metrics.xdpi} dot/inch
                Y Dimension: ${metrics.ydpi} dot/inch
                The screen density expressed as dots-per-inch: ${metrics.densityDpi}
                A scaling factor for fonts displayed on the display: ${metrics.scaledDensity}
            """
                }
            }else{
                // getMetrics() method was deprecated in api level 30
                windowManager.defaultDisplay.getMetrics(metrics)
                screen = """
        Width: ${metrics.widthPixels} pixels
        Height: ${metrics.heightPixels} pixels 
        The Logical Density: ${metrics.density}  
        X Dimension: ${metrics.xdpi} dot/inch
        Y Dimension: ${metrics.ydpi} dot/inch
        The screen density expressed as dots-per-inch: ${metrics.densityDpi}
        A scaling factor for fonts displayed on the display: ${metrics.scaledDensity}"""
            }

            val infoTextView = findViewById<TextView>(R.id.textView2)
            infoTextView.text = screen
        }


    }
}