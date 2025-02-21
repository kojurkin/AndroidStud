package com.example.lab17

import android.content.Context
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.view.View

class Draw2D(context: Context?) : View(context) {
    private val paint: Paint = Paint()
    private val res: Resources = this.resources
    private val originalBitmap: Bitmap = BitmapFactory.decodeResource(res, R.drawable.cat)
    private val bitmap: Bitmap

    init {
        // Масштабируем изображение до нужных размеров
        val targetWidth = 200 // желаемая ширина изображения
        val targetHeight = 200 // желаемая высота изображения
        bitmap = Bitmap.createScaledBitmap(originalBitmap, targetWidth, targetHeight, true)
    }

    private val rect: Rect = Rect()

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // Фон
        paint.apply {
            style = Paint.Style.FILL
            color = Color.WHITE
        }
        canvas.drawPaint(paint)

        // Солнце
        paint.apply {
            isAntiAlias = true
            color = Color.YELLOW
        }
        canvas.drawCircle(950F, 30F, 25F, paint)

        // Лужайка
        paint.color = Color.GREEN
        canvas.drawRect(20F, 650F, 950F, 680F, paint)

        // Текст над лужайкой
        paint.apply {
            color = Color.BLUE
            style = Paint.Style.FILL
            isAntiAlias = true
            textSize = 32F
        }
        canvas.drawText("Лужайка только для котов", 30F, 648F, paint)

        // Лучик солнца
        val x = 810F
        val y = 190F
        paint.apply {
            color = Color.GRAY
            style = Paint.Style.FILL
            textSize = 27F
        }
        val str2rotate = "Лучик солнца!"
        canvas.save()
        canvas.rotate(-45F, x + rect.exactCenterX(), y + rect.exactCenterY())
        canvas.drawText(str2rotate, x, y, paint)
        canvas.restore()

        // Кот
        canvas.drawBitmap(
            bitmap,
            600F, // Смещение по оси X
            480F, // Смещение по оси Y
            paint
        )
    }
}