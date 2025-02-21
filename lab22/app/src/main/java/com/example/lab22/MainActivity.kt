package com.example.lab22

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.map.CameraPosition
import com.yandex.mapkit.map.MapObjectTapListener
import com.yandex.mapkit.mapview.MapView
import com.yandex.runtime.image.ImageProvider

class MainActivity : AppCompatActivity() {
    private lateinit var mapView: MapView
    private val markTapListener = MapObjectTapListener { _, _ ->
        Toast.makeText(
            this@MainActivity,
            "Вы нажали на 4 корпус ОмГУ",
            Toast.LENGTH_SHORT
        ).show()
        true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Инициализация Yandex MapKit с API-ключом
        MapKitFactory.setApiKey(getString(R.string.yandex_mapkit_api_key))
        MapKitFactory.initialize(this)

        setContentView(R.layout.activity_main)
        mapView = findViewById(R.id.mapview)

        // Перемещение камеры на нужную точку
        val targetLocation = Point(55.030556, 73.269444)
        mapView.mapWindow.map.move(
            CameraPosition(targetLocation, 16.0f, 150.0f, 30.0f)
        )

        // Добавление метки на карту
        val imageProvider = ImageProvider.fromResource(this, android.R.drawable.ic_menu_mylocation)
        val mark = mapView.mapWindow.map.mapObjects.addPlacemark().apply {
            geometry = targetLocation
            setIcon(imageProvider)
        }

        mark.addTapListener(markTapListener)

        // Обработка системных отступов
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.mapview)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onStart() {
        super.onStart()
        MapKitFactory.getInstance().onStart()
        mapView.onStart()
    }

    override fun onStop() {
        super.onStop()
        MapKitFactory.getInstance().onStop()
        mapView.onStop()
    }
}