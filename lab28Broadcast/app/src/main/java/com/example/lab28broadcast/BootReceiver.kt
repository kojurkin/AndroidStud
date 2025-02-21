package com.example.lab28broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
//Мы создали отдельный класс для широковещательного сообщения. Также нужно создать разрешение и зарегистрировать приёмник в манифесте.
class BootReceiver: BroadcastReceiver() {
    private lateinit var context: Context
    private val BOOT_ACTION: String = "android.intent.action.BOOT_COMPLETED"

    override fun onReceive(context: Context, intent: Intent) {
        this.context = context
        val action = intent.action

        if (action.equals(BOOT_ACTION, true)) {
            val activityIntent = Intent(context, MainActivity::class.java)
            activityIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(activityIntent)
        }
    }
}