package com.example.lab19

import android.annotation.SuppressLint
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val webView: WebView = findViewById(R.id.webView)

        // Настройка WebView
        webView.webViewClient = MyWebViewClient()
        webView.settings.javaScriptEnabled = true // Включаем поддержку JavaScript

        // Загружаем стартовую страницу
        webView.loadUrl("https://www.gismeteo.ru/weather-omsk-4578/")

    }

    // Переопределение метода обработки нажатия кнопки "Назад"
    override fun onBackPressed() {
        val webView: WebView = findViewById(R.id.webView)
        if (webView.canGoBack()) {
            webView.goBack()
        } else {
            super.onBackPressed()
        }
    }

    // Настройка WebViewClient для обработки ссылок
    private class MyWebViewClient : WebViewClient() {
        override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
            // Все ссылки открываются внутри WebView
            view.loadUrl(url)
            return true
        }
    }
}